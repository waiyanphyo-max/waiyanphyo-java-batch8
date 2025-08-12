package main.java.talent_program.java.java_8.Day_10.TransWithDB;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/tpp_db";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        while (true) {
        System.out.println(" ");
        System.out.println("Do you already have an account.");
        System.out.println("Answer [Y]es or [N]o");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (Objects.equals(input, "Y")) {
                chooseWhatToDo();
                return;
            } else if (Objects.equals(input, "N")) {
                initializeBalance();
                return;
            } else {
                System.out.println("Invalid Input.");
            }
        }

    }

    private static void chooseWhatToDo() throws SQLException {
        Scanner scanner  = new Scanner(System.in);

        while (true) {
            System.out.println(" ");
            System.out.println("What do you want to do? Choose :: ");
            System.out.println("1. Add Expense, 2. Add Income, 3. View All Transactions, 4. View Total expense by Category");
            System.out.println("5. View expense and income  Monthly Summary, 6. Remove Transaction, 0. Exit");

            int input = 0;
            while (true) {
                try {
                    input = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid Input. Please enter number.");
                    scanner.nextLine();
                }
            }

            if (input == 1) {
                addExpense();
            } else if (input == 2) {
                addIncome();
            } else if (input == 3) {
                viewAllTransaction();
            } else if (input == 4) {
                viewTotalExpenseByCat();
            } else if (input == 5) {
                viewMonthlySummary();
            } else if (input == 6) {
                deleteTransaction();
            } else if (input == 0) {
                break;
            }
        }
    }

    private static void deleteTransaction() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("You want to delete transaction from what (type). Choose [1].Expense and [2].Income");
        TransType transType = chooseTranType();
        System.out.println(" ");
        System.out.println("Choose from given categories.");
        String category = chooseCategory(transType);
        System.out.println(" ");
        System.out.printf("Here are all transaction from category : %s%n", category);
        displayTransactionByCat(category);
        System.out.println(" ");
        System.out.println("Choose by id to delete transaction.");
        int input = scanner.nextInt();
        deleteById(input);
    }

    private static void deleteById(int input) {
        try (Connection connection = connectDb()) {
            assert connection != null;
            String sql = "delete from transaction where tran_id = ?";
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setInt(1, input);
            prepStmt.executeUpdate();
            System.out.printf("Delete transaction with id = %s is successfully.%n", input);
        } catch (SQLException e) {
            System.out.println("Something went wrong.");
        }
    }

    private static void displayTransactionByCat(String category) throws SQLException {
        Connection connection = connectDb();

        try (connection) {
            String sql = "select * from transaction where tran_category = ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\n--- All Transactions ---");
            System.out.printf("%-5s %-10s %-10s %-20s %-20s %-20s %-20s %-12s %-30s%n",
                    "ID", "Amount", "Type", "Category", "Created At", "Updated At", "Deleted At", "Del Flag", "Note");

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            while (resultSet.next()) {
                int id = resultSet.getInt("tran_id");
                double amount = resultSet.getDouble("amount");
                String type = resultSet.getString("tran_type");
                String displayCategory = resultSet.getString("tran_category");
                Timestamp createdAt = resultSet.getTimestamp("created_at");
                Timestamp updatedAt = resultSet.getTimestamp("updated_at");
                Timestamp deletedAt = resultSet.getTimestamp("deleted_at");
                int deleteFlag = resultSet.getInt("delete_flag");
                String note = resultSet.getString("note");

                String createdAtStr = createdAt != null ? createdAt.toLocalDateTime().format(dateFormatter) : "N/A";
                String updatedAtStr = updatedAt != null ? updatedAt.toLocalDateTime().format(dateFormatter) : "N/A";
                String deletedAtStr = deletedAt != null ? deletedAt.toLocalDateTime().format(dateFormatter) : "N/A";

                System.out.printf("%-5d %-10.2f %-10s %-20s %-20s %-20s %-20s %-12d %-30s%n",
                        id,
                        amount,
                        type != null ? type : "N/A",
                        displayCategory != null ? displayCategory : "N/A",
                        createdAtStr,
                        updatedAtStr,
                        deletedAtStr,
                        deleteFlag,
                        note != null ? note : "");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    private static String chooseCategory(TransType transType) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose from below list of categories.");
            try {
                int input;
                if (transType == TransType.INCOME) {
                    displayIncomeCategories();
                    IncomeCategory[] incomeCategories = IncomeCategory.values();
                    System.out.println("Choose a number.");
                    try {
                        input = scanner.nextInt();
                        scanner.nextLine();
                        return incomeCategories[input-1].getDisplayName();
                    } catch (Exception e) {
                        System.out.println("Please choose from given list.");
                        scanner.nextLine();
                    }
                } else {
                    displayExpenseCategories();
                    ExpenseCategory[] expenseCategories = ExpenseCategory.values();
                    System.out.println("Choose a number.");
                    try {
                        input = scanner.nextInt();
                        scanner.nextLine();
                        return expenseCategories[input-1].getDisplayName();
                    } catch (Exception e) {
                        System.out.println("Please choose from given list.");
                        scanner.nextLine();
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private static void viewMonthlySummary() throws SQLException {
        PreparedStatement prepStmt;
        try (Connection connection = connectDb()) {
            assert connection != null;
            System.out.println(" ");
            System.out.println("What transaction type do you want to check. Choose [1].Expense (or) [2].Income");
            TransType transType = chooseTranType();
            String tranTypeStr = transType.toString();
            DateRange range = inputDate();
            LocalDateTime startOfMonth = range.start;
            LocalDateTime endOfMonth = range.end;
            System.out.printf("\n--- Monthly Summary of %s in %s are -%n", tranTypeStr, YearMonth.from(startOfMonth));
            String sql = "select note, amount, created_at from transaction where tran_type = ? && created_at between ? and ?";

            prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, tranTypeStr);
            prepStmt.setTimestamp(2, Timestamp.valueOf(startOfMonth));
            prepStmt.setTimestamp(3, Timestamp.valueOf(endOfMonth));
        ResultSet resultSet = prepStmt.executeQuery();

        System.out.printf("%-30s %-10s %-20s%n", "Note", "Amount", "Created At");

        while (resultSet.next()) {
            String note = resultSet.getString("note");
            Double amount = resultSet.getDouble("amount");
            LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();

            System.out.printf(
                    "%-30s %-10.2f %-20s%n",
                    note != null ? note : "",
                    amount,
                    createdAt != null ? createdAt : "N/A"
            );
        }
    }

    }

    private static class DateRange {
        LocalDateTime start;
        LocalDateTime end;

        public DateRange(LocalDateTime start, LocalDateTime end) {
            this.start = start;
            this.end = end;
        }
    }

    private static DateRange inputDate() {
        while (true) {
            try {
                System.out.println("Enter year and month do you want to check.");
                System.out.println("Example : yyyy-MM");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
                YearMonth yearMonth = YearMonth.parse(input, formatter);
                LocalDateTime startOfMonth = yearMonth.atDay(1).atStartOfDay();
                LocalDateTime endOfMonth = yearMonth.atEndOfMonth().atTime(23, 59, 59);
                return new DateRange(startOfMonth, endOfMonth);
            } catch (Exception e) {
                System.out.println("Try again. Invalid input.");
            }
        }
    }

    private static TransType chooseTranType() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                TransType[] transTypes = TransType.values();
                TransType transType = null;
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input >= 1 && input <= 2) {
                    transType = transTypes[input -1];
                    return transType;
                } else {
                    System.out.println("Please choose 1 or 2.");
                }
            } catch (Exception e) {
                System.out.println("Try again. Invalid input");
                scanner.nextLine();
            }
        }
    }

    private static void viewTotalExpenseByCat() throws SQLException {
        Connection connection = connectDb();
        assert connection != null;
        selectExpenseByCat(connection);
    }

    private static void selectExpenseByCat(Connection connection) throws SQLException {
        System.out.println(" ");
        System.out.println("Choose from given categories : ");
        ExpenseCategory expenseCategory = chooseExpense();

        String sql = "select sum(amount) AS total_expense from transaction where tran_type = 'EXPENSE' and tran_category = ?";
        PreparedStatement prepStmt = connection.prepareStatement(sql);
        prepStmt.setString(1, expenseCategory.getDisplayName());
        ResultSet resultSet = prepStmt.executeQuery();

        if (resultSet.next()) {
            double totalAmount = resultSet.getDouble("total_expense");
            System.out.printf("\nTotal expense for %s is %s%n", expenseCategory.getDisplayName(), totalAmount);
        }

    }

    private static void displayExpenseCategories() {
        ExpenseCategory[] expenseCategories = ExpenseCategory.values();
        String categories = "";
        int i = 1;
        for (ExpenseCategory expenseCategory : expenseCategories) {
            if (i == expenseCategories.length) {
                categories = categories.concat("[%d]. %s.".formatted(i, expenseCategory));
            } else {
                categories = categories.concat("[%d]. %s, ".formatted(i, expenseCategory));
                i++;
            }
        }
        System.out.println(categories);
    }

    private static void displayIncomeCategories() {
        IncomeCategory[] incomeCategories = IncomeCategory.values();
        String categories = "";
        int i = 1;
        for (IncomeCategory incomeCategory : incomeCategories) {
            if (i == incomeCategories.length) {
                categories = categories.concat("[%d]. %s.".formatted(i, incomeCategory));
            } else {
                categories = categories.concat("[%d]. %s, ".formatted(i, incomeCategory));
                i++;
            }
        }
        System.out.println(categories);
    }

    private static void viewAllTransaction() throws SQLException {
        Connection connection = connectDb();
        assert connection != null;
        selectAllTransaction(connection);
    }

    private static void selectAllTransaction(Connection connection) throws SQLException {
        try (connection) {
            String sql = "select * from transaction";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("\n--- All Transactions ---");
            System.out.printf("%-5s %-10s %-10s %-20s %-20s %-20s %-20s %-12s %-30s%n",
                    "ID", "Amount", "Type", "Category", "Created At", "Updated At", "Deleted At", "Del Flag", "Note");

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            while (resultSet.next()) {
                int id = resultSet.getInt("tran_id");
                double amount = resultSet.getDouble("amount");
                String type = resultSet.getString("tran_type");
                String category = resultSet.getString("tran_category");
                Timestamp createdAt = resultSet.getTimestamp("created_at");
                Timestamp updatedAt = resultSet.getTimestamp("updated_at");
                Timestamp deletedAt = resultSet.getTimestamp("deleted_at");
                int deleteFlag = resultSet.getInt("delete_flag");
                String note = resultSet.getString("note");

                String createdAtStr = createdAt != null ? createdAt.toLocalDateTime().format(dateFormatter) : "N/A";
                String updatedAtStr = updatedAt != null ? updatedAt.toLocalDateTime().format(dateFormatter) : "N/A";
                String deletedAtStr = deletedAt != null ? deletedAt.toLocalDateTime().format(dateFormatter) : "N/A";

                System.out.printf("%-5d %-10.2f %-10s %-20s %-20s %-20s %-20s %-12d %-30s%n",
                        id,
                        amount,
                        type != null ? type : "N/A",
                        category != null ? category : "N/A",
                        createdAtStr,
                        updatedAtStr,
                        deletedAtStr,
                        deleteFlag,
                        note != null ? note : "");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void addIncome() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Transaction transaction = new Transaction();
        System.out.println(" ");
        System.out.println("Enter an amount.");
        double amount = scanner.nextDouble();
        transaction.setAmount(amount);
        System.out.println(" ");
        transaction.setTran_type(TransType.INCOME);
        chooseCategory(transaction);
        scanner.nextLine();
        System.out.println(" ");
        System.out.println("Enter a note for this transaction.");
        String note = scanner.nextLine();
        transaction.setNote(note);
        transaction.setCreated_at(LocalDateTime.now());

        Connection connection = connectDb();
        assert connection != null;
        addTransaction(transaction, connection);
    }

    private static void addExpense() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Transaction transaction = new Transaction();
        System.out.println(" ");
        System.out.println("Enter an amount.");
        double amount = scanner.nextDouble();
        transaction.setAmount(amount);
        System.out.println(" ");
        transaction.setTran_type(TransType.EXPENSE);
        chooseCategory(transaction);
        scanner.nextLine();
        System.out.println(" ");
        System.out.println("Enter a note for this transaction.");
        String note = scanner.nextLine();
        transaction.setNote(note);
        transaction.setCreated_at(LocalDateTime.now());


        Connection connection = connectDb();
        assert connection != null;
        addTransaction(transaction, connection);
    }

    private static void chooseCategory(Transaction transaction) {
        System.out.println(" ");
        System.out.println("Choose from given categories.");
        if (transaction.getTran_type() == TransType.INCOME) {
            chooseIncome(transaction);
        } else {
            chooseExpense(transaction);
        }
    }

    private static void chooseIncome(Transaction transaction) {
        Scanner scanner = new Scanner(System.in);
        IncomeCategory[] incomeCategories = IncomeCategory.values();
        displayIncomeCategories();
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                if (input >= 1 && input <= incomeCategories.length) {
                    transaction.setTranCategory(incomeCategories[input -1]);
                    break;
                } else {
                    System.out.println(" ");
                    System.out.println("Please choose from the given list.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void chooseExpense(Transaction transaction) {
        Scanner scanner = new Scanner(System.in);
        ExpenseCategory[] expenseCategories = ExpenseCategory.values();
        displayExpenseCategories();
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input >= 1 && input <= expenseCategories.length) {
                    transaction.setTranCategory(expenseCategories[input - 1]);
                    break;
                } else {
                    System.out.println(" ");
                    System.out.println("Please choose from the given list.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static ExpenseCategory chooseExpense() {
        Scanner scanner = new Scanner(System.in);
        ExpenseCategory[] expenseCategories = ExpenseCategory.values();
        displayExpenseCategories();
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input >= 1 && input <= expenseCategories.length) {
                    return expenseCategories[input-1];
                } else {
                    System.out.println(" ");
                    System.out.println("Please choose from the given list.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

//    private static void chooseTranType(Transaction transaction) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(" ");
//        System.out.println("Choose transaction type");
//        System.out.println("[1]. Income, [2]. Expense.");
//        while (true) {
//            try {
//                int input = scanner.nextInt();
//
//                TransType[] transTypes = TransType.values();
//                if (input >= 1 && input <=2) {
//                    transaction.setTran_type(transTypes[input - 1]);
//                    break;
//                } else {
//                    System.out.println("Please choose from given list.");
//                }
//            } catch (Exception e) {
//                System.out.println("Try again.Please enter a number.");
//            }
//        }
//
//    }

    private static void initializeBalance() throws SQLException, ClassNotFoundException {

        System.out.println(" ");
        System.out.println("Enter the initial balance.");
        Scanner scanner = new Scanner(System.in);

        Transaction transaction = new Transaction();
        while (true) {
            try {
                Double balance = scanner.nextDouble();
                transaction.setAmount(balance);
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Try again.Please enter number.");
            }
        }

        System.out.println(" ");
        System.out.println("Enter a note for transaction.");
        String note = scanner.nextLine();
        transaction.setNote(note);
        transaction.setTran_type(TransType.INCOME);
        chooseCategoryForInit(transaction);
        transaction.setCreated_at(LocalDateTime.now());

        Connection connection = connectDb();
        assert connection != null;
        addTransaction(transaction, connection);

    }

    private static void addTransaction(Transaction transaction, Connection connection) throws SQLException {
        try {
            String sql = "insert into transaction(amount, tran_type, tran_category, created_at, note) values(?,?,?,?,?)";
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setDouble(1, transaction.getAmount());
            prepStmt.setString(2, transaction.getTran_type().toString());
            prepStmt.setString(3, transaction.getTranCategory().toString());
            prepStmt.setTimestamp(4, Timestamp.valueOf(transaction.getCreated_at()));
            prepStmt.setString(5, transaction.getNote());
            prepStmt.executeUpdate();
            System.out.println("Transaction is added.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Connection connectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Mysql JDBC Driver loaded.");

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("Connected to the database.");
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load Mysql JDBC driver.");
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
        }
        return null;
    }

    private static void chooseCategoryForInit(Transaction transaction) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" ");
            System.out.println("Choose Income category from below.");
            IncomeCategory[] incomeCategories = IncomeCategory.values();
            String categories = "";

            for (int i = 0; i < incomeCategories.length; i++) {
                if (i < incomeCategories.length - 1) {
                    categories = categories.concat("[%d]. %s, ".formatted(i + 1, incomeCategories[i].getDisplayName()));
                } else {
                    categories = categories.concat("[%d]. %s.".formatted(i + 1, incomeCategories[i].getDisplayName()));
                }
            }
            System.out.println(categories);
            System.out.println("Enter your choice:");
            try {
                int input = scanner.nextInt();
                if (input >=1 && input <=categories.length()) {
                    transaction.setTranCategory(incomeCategories[input-1]);
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number from list.");
                }

            } catch (Exception e) {
                System.out.println("Try again. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private static void getAccount() {

    }

}
