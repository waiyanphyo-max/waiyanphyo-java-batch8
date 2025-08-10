package main.java.talent_program.java.java_8.Day_9.TransactionCli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var transactions = new ArrayList<Transaction>();

        System.out.println(" ");
        System.out.println("Do you already have an account.");
        System.out.println("Answer [Y]es or [N]o");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (Objects.equals(input, "Y")) {
            getTransactions(transactions);
        } else {
            initialBalance(transactions);
        }

        chooseWhatToDo();
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();

        while (true) {
            if (choose == 1) {
                addExpense(transactions);
                chooseWhatToDo();
                choose = sc.nextInt();
            } else if (choose == 2) {
                addIncome(transactions);
                chooseWhatToDo();
                choose = sc.nextInt();
            } else if (choose== 3) {
                viewAllTransactions(transactions);
                chooseWhatToDo();
                choose = sc.nextInt();
            } else if (choose == 4) {
                viewTotalExpense(transactions);
                chooseWhatToDo();
                choose = sc.nextInt();
            } else if (choose == 5) {
                viewMonthlySummary(transactions);
                chooseWhatToDo();
                choose = sc.nextInt();
            } else if (choose == 6) {
                removeTransaction(transactions);
                chooseWhatToDo();
                choose = sc.nextInt();
            } else if (choose == 0) {
                saveAndExit(transactions);
                break;
            }
        }
    }

    private static void saveAndExit(ArrayList<Transaction> transactions) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a file to store your data.");
            System.out.println("Example  : C:\\users\\text");
            String input = sc.nextLine();
            String folder = input.replace("\\", "\\\\");
            String textFile = STR."\{folder}.txt";
            File myFile = new File(textFile);
            if(myFile.createNewFile()) {
                FileWriter myWriter = new FileWriter(textFile);
                for (Transaction transaction : transactions) {

                    myWriter.write(STR."""
\{String.valueOf(transaction)}
""");
                }
                myWriter.close();
                System.out.println(" ");
                System.out.println("File is written successfully");
            } else {
                    if (myFile.delete()) {
                        myFile = new File(textFile);
                        if (myFile.createNewFile()) {
                            FileWriter myWriter = new FileWriter(textFile);
                            for (Transaction transaction : transactions) {

                                myWriter.write(STR."""
\{String.valueOf(transaction)}
""");
                            }
                            myWriter.close();
                            System.out.println(" ");
                            System.out.println("File is written successfully");
                        } else {
                            System.out.println("Something went wrong");
                        }
                    } else {
                        System.out.println("Something went wrong");
                    }
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }

    private static void removeTransaction(ArrayList<Transaction> transactions) {
        
        Transaction transaction = chooseTransaction(transactions);
        
        transactions.remove(transaction);
        System.out.println(" ");
        System.out.printf("Transaction with id : %s is removed successfully.%n", transaction.getId());
    }

    private static Transaction chooseTransaction(ArrayList<Transaction> transactions) {

        System.out.println(" ");
        System.out.println("Choose a transaction to remove");
        
        Transaction[] transactions1 = (transactions.toArray(new Transaction[0]));
        
        for (int i = 0; i < transactions1.length; i++) {
            System.out.println(i+1+"-");
            System.out.println(transactions1[i].toString());
        }
        
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            System.out.println("Enter numbers.");

            if (scanner.hasNextInt()) {
                input = scanner.nextInt();

                if(input >= 1 && input <= transactions1.length) {
                    return transactions1[input-1];
                } else {
                    System.out.println("Please choose only from the category list.");
                }
            } else {
                System.out.println("Please enter a number!");
                scanner.next();
            }
        }
    }

    private static void chooseWhatToDo() {
        System.out.println(" ");
        System.out.println("What do you want to do? Choose :: ");
        System.out.println("1. Add Expense, 2. Add Income, 3. View All Transactions, 4. View Total expense by Category");
        System.out.println("5. View expense and income  Monthly Summary, 6. Remove Transaction, 0. Exit");
    }

    private static void viewMonthlySummary(ArrayList<Transaction> transactions) {
         YearMonth yearMonth = inputDate();

        for (Transaction transaction : transactions) {
            if (YearMonth.from(transaction.getTransDate()).equals(yearMonth)) {
                System.out.println(" ");
                System.out.println(transaction.toString());
            }
        }
    }

    private static void viewTotalExpense(ArrayList<Transaction> transactions) {

        Category category = chooseCategory();
        
        double result = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getTransType() == TransType.expense && transaction.getCategory() == category) {
                result += transaction.getAmount();
            }
        }

        System.out.println(" ");
        System.out.printf("Total expense of category %s is %s%n", category, result);
    }

    private static Category chooseCategory() {
        System.out.println("Choose Category you want to check expenses:");
        Category[] categories = Category.values();
        String categoriesNum = "";
        for (int i = 0; i < categories.length; i++) {
            if (i < categories.length - 1) {
                categoriesNum = categoriesNum.concat("%s. %s, ".formatted(i+1, categories[i]));
            } else if (i == categories.length - 1) {
                categoriesNum = categoriesNum.concat("%s. %s".formatted(i+1, categories[i]));
            }
        }
        System.out.println(categoriesNum);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter number: ");

            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();

                if (input == 0) {
                    return null;
                }

                if (input >= 1 && input <= categories.length) {
                    return categories[input - 1];
                } else {
                    System.out.println("Please choose only from the category list.");
                }
            } else {
                System.out.println("Please enter a number!");
                scanner.next();
            }
        }

    }

    private static void viewAllTransactions(ArrayList<Transaction> transactions) {
        
        for (Transaction transaction : transactions) {
            System.out.println(" ");
            System.out.println(transaction.toString()+"\n");
        }
    }

    private static void addIncome(ArrayList<Transaction> transactions) {
        Transaction transaction = new Transaction();
        
        transaction.setTransType(TransType.income);
        chooseCategory(transaction);
        inputAmount(transaction);
        inputDate(transaction);
        transactions.add(transaction);
        System.out.println(" ");
        System.out.println("Transaction done successfully.");
    }

    private static void addExpense(ArrayList<Transaction> transactions) {

        Transaction transaction = new Transaction();
        
        transaction.setTransType(TransType.expense);
        chooseCategory(transaction);
        inputAmount(transaction);
        inputDate(transaction);
        transactions.add(transaction);
        System.out.println(" ");
        System.out.println("Transaction done successfully.");

    }

    private static void inputDate(Transaction transaction) {
        System.out.println("Enter date of transaction.");
        System.out.println("Example : yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(input, formatter);
        transaction.setTransDate(date);

    }

    private static YearMonth inputDate() {
        System.out.println("Enter year and month do you want to check.");
        System.out.println("Example : yyyy-MM");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        return YearMonth.parse(input, formatter);
    }

    private static void inputAmount(Transaction transaction) {
        System.out.println("Enter an amount.");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextInt();
        transaction.setAmount(amount);
    }

    private static void chooseCategory(Transaction transaction) {
        System.out.println("Choose a category");
        Category[] categories = Category.values();

        String categoriesNum = "";
        for (int i = 0; i < categories.length; i++) {
            if (i < categories.length - 1) {
                categoriesNum = categoriesNum.concat("%s. %s, ".formatted(i+1, categories[i]));
            } else if (i == categories.length - 1) {
                categoriesNum = categoriesNum.concat("%s. %s".formatted(i+1, categories[i]));
            }
        }
        System.out.println(categoriesNum);
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        try {
            if (input <= categories.length) {
                for (int i = 0; i < categories.length; i++) {
                    if (input == i+1) {
                        transaction.setCategory(categories[i]);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(" ");
            System.out.println("Please choose only from category list.");
        }
    }

    private static void initialBalance(ArrayList<Transaction> transactions) {

        Transaction transaction = new Transaction();

        System.out.println("Enter initial balance.");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        transaction.setTransType(TransType.income);
        transaction.setCategory(Category.salary);
        transaction.setAmount(amount);
        inputDate(transaction);
        transactions.add(transaction);
        System.out.println(" ");
        System.out.printf("Your current balance is %s%n", amount);
    }

    public static void getTransactions(ArrayList<Transaction> transactions) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a file in that stored transactions.");
            System.out.println("Example  : C:\\users\\text_file");
            String input = sc.nextLine();
            String textFile = input.replace("\\", "\\\\");
            String lastFile = textFile.concat(".txt");
            File myFile = new File(lastFile);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                Transaction transaction = new Transaction();
                String result = myReader.nextLine();
                String result1 = result.substring(result.indexOf("{") + 1, result.lastIndexOf("}"));

                String[] array = result1.split(", ");
                HashMap<String, String> hashMap = new HashMap<>();
                for (String string : array) {
                    String[] keyValue = string.split("=");
                    hashMap.put(keyValue[0], keyValue[1]);
                }
                transaction.setId(Long.parseLong(hashMap.get("id")));
                transaction.setTransType(TransType.valueOf(hashMap.get("transType")));
                transaction.setCategory(Category.valueOf(hashMap.get("category")));
                transaction.setAmount(Double.parseDouble(hashMap.get("amount")));
                transaction.setTransDate(LocalDate.parse(hashMap.get("transDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                transactions.add(transaction);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong");
        }

    }

}
