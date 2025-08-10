package main.java.talent_program.java.java_8.Day_9.TaskCli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CommandMain {
    public static void main(String[] args) {
        final ArrayList<Task> tasks = new ArrayList<>();

        System.out.println(" ");
        System.out.println("Do you already have an account.");
        System.out.println("Answer [Y]es or [N]o");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (Objects.equals(input, "Y")) {
            getAccount(tasks);
        } else {
            addTask(tasks);
        }

        chooseWhatToDo(tasks);
    }

    private static void chooseWhatToDo(ArrayList<Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

        System.out.println(" ");
        System.out.println("Choose what to do.");
        System.out.println("1. Add Task, 2. Add Done Task, 3. View All Tasks, 4. View Tasks Sorted by Deadline");
        System.out.println("5. View Tasks Sorted by Priority, 6. Remove Task, 0. Exit");

        int input = scanner.nextInt();

            if (input == 1) {
                addTask(tasks);
            } else if (input == 2) {
                markTasksDone(tasks);
            } else if (input == 3) {
                viewAllTasks(tasks);
            } else if (input == 4) {
                viewSortedByDeaLin(tasks);
            } else if (input == 5) {
                viewSortedByPrio(tasks);
            } else if (input == 6) {
                removeTasks(tasks);
            } else if (input == 0) {
                saveAndExit(tasks);
                break;
            }
        }
    }

    private static void saveAndExit(ArrayList<Task> tasks) {
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
                for (Task task : tasks) {

                    myWriter.write(STR."""
\{String.valueOf(task)}
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
                        for (Task task : tasks) {

                            myWriter.write(STR."""
\{String.valueOf(task)}
""");
                        }
                        myWriter.close();
                        System.out.println(" ");
                        System.out.println("File is written successfully");
                        sc.close();
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

    private static void removeTasks(ArrayList<Task> tasks) {
        System.out.println("Choose tasks do you want to remove.");
        System.out.println("Example :: 1,2,3");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] strings = input.split(",");

        ArrayList<Integer> integers = new ArrayList<>();

        for (String string : strings) {
            integers.add(Integer.parseInt(string));
        }

        Integer[] intArray = integers.toArray(new Integer[0]);

        Task[] taskArray = tasks.toArray(new Task[0]);

        ArrayList<Task> removedTasks = new ArrayList<>();

        for (int i = 0; i < taskArray.length; i++) {
            for (Integer integer : intArray) {
                if (integer-1 == i) {
                    tasks.remove(taskArray[i]);
                    removedTasks.add(taskArray[i]);
                }
            }
        }

        Task[] removedArray = removedTasks.toArray(new Task[0]);
        String removedTasksStr = "";
        for (int i = 0; i < removedArray.length; i++) {
            if (i < removedArray.length -1) {
                removedTasksStr = removedTasksStr.concat(STR."\{removedArray[i].getDescription()}, ");
            }
            removedTasksStr = removedTasksStr.concat(removedArray[i].getDescription());
        }
        System.out.printf("%s are removed successfully.", removedTasksStr);
    }

    private static void viewSortedByPrio(ArrayList<Task> tasks) {
        HashMap<Priority, Integer> hashMap = new HashMap<>();
        hashMap.put(Priority.High, 1);
        hashMap.put(Priority.Medium, 2);
        hashMap.put(Priority.Low, 3);

        tasks.sort(Comparator.comparingInt(t -> hashMap.get(t.getPriority())));

        int i = 1;
        for (Task task : tasks) {
            System.out.printf("%s. %s%n", i, task.toString());
            i++;
        }
    }

    private static void viewSortedByDeaLin(ArrayList<Task> tasks) {

        ArrayList<Task> unDoneTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStatus().equals(Status.Undone)) {
                unDoneTasks.add(task);
            }
        }

        unDoneTasks.sort(Comparator.comparingLong(
                t -> Math.abs(ChronoUnit.DAYS.between(LocalDate.now(), t.getDeadLine()))
        ));

        System.out.println("Here are undone tasks.");
        int i = 1;
        for (Task task : unDoneTasks) {
            System.out.printf("%s. %s%n", i, task.toString());
            i++;
        }
    }

    private static void viewAllTasks(ArrayList<Task> tasks) {
        Task[] taskArray = tasks.toArray(new Task[0]);

        int i = 1;
        for (Task task : taskArray) {
            System.out.printf("%s. %s%n", i, task.toString());
            i++;
        }
    }

    private static void markTasksDone(ArrayList<Task> tasks) {
        System.out.println("Choose tasks what do you done.");
        System.out.println("Example :: 1,2,3");

        Task[] taskArray = tasks.toArray(new Task[0]);

        ArrayList<Task> unDoneTasks = new ArrayList<>();

        int j = 1;
        for (Task task : taskArray) {
            if (task.getStatus() == Status.Undone) {
                System.out.printf("%s. %s%n", j, task.toString());
                unDoneTasks.add(task);
                j++;
            }
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] strings = input.split(",");

        ArrayList<Integer> integers = new ArrayList<>();

        for (String string : strings) {
            integers.add(Integer.parseInt(string));
        }

        Integer[] intArray = integers.toArray(new Integer[0]);

        Task[] undoneArray = unDoneTasks.toArray(new Task[0]);

        ArrayList<Task> doneTask = new ArrayList<>();

        for (int i = 0; i < undoneArray.length; i++) {
            for (Integer integer : intArray) {
                if (integer-1 == i) {
                    undoneArray[i].setStatus(Status.Done);
                    doneTask.add(undoneArray[i]);
                }
            }
        }

        Task[] doneTaskArray = doneTask.toArray(new Task[0]);
        String doneTasks = "";
        for (int i = 0; i < doneTaskArray.length; i++) {
            if (i < doneTaskArray.length-1) {
                doneTasks = doneTasks.concat(doneTaskArray[i].getDescription()+", ");
            } else {
                doneTasks = doneTasks.concat(doneTaskArray[i].getDescription());
            }
        }

        System.out.printf("%s are marked as done.", doneTasks);
    }

    public static void getAccount(ArrayList<Task> tasks) {
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
                Task task = new Task();
                String result = myReader.nextLine();
                String result1 = result.substring(result.indexOf("{") + 1, result.lastIndexOf("}"));

                String[] array = result1.split(", ");
                HashMap<String, String> hashMap = new HashMap<>();
                for (String string : array) {
                    String[] keyValue = string.split("=");
                    hashMap.put(keyValue[0], keyValue[1]);
                }
                task.setId(Long.parseLong(hashMap.get("id")));
                task.setDescription(hashMap.get("description"));
                task.setPriority(Priority.valueOf(hashMap.get("priority")));
                task.setStatus(Status.valueOf(hashMap.get("status")));
                task.setDeadLine(LocalDate.parse(hashMap.get("deadLine"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                tasks.add(task);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong");
        }

    }

    private static void addTask(ArrayList<Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println(" ");
        System.out.println("Firstly you need to add tasks.");
        do {
            Task task = new Task();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter description");
            String description = sc.nextLine();
            task.setDescription(description);
            inputPriority(task);
            inputDate(task);
            task.setStatus(Status.Undone);
            tasks.add(task);
            System.out.println("Do you want to add more tasks? [Y]es (or) [N]o");
            input = scanner.nextLine();
        } while (Objects.equals(input, "Y"));
    }

    private static void inputStatus(Task task) {
        System.out.println("Choose a status for task.");
        Status[] statuses = Status.values();

        String statusesNum = "";
        for (int i = 0; i < statuses.length; i++) {
            if (i < statuses.length - 1) {
                statusesNum = statusesNum.concat("%s. %s, ".formatted(i+1, statuses[i]));
            } else if (i == statuses.length - 1) {
                statusesNum = statusesNum.concat("%s. %s".formatted(i+1, statuses[i]));
            }
        }
        System.out.println(statusesNum);
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        try {
            if (input <= statuses.length) {
                for (int i = 0; i < statuses.length; i++) {
                    if (input == i+1) {
                        task.setStatus(statuses[i]);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(" ");
            System.out.println("Please choose only from status list.");
        }
    }

    private static void inputPriority(Task task) {
            System.out.println("Choose a priority for task.");
            Priority[] priorities = Priority.values();

            String prioritiesNum = "";
            for (int i = 0; i < priorities.length; i++) {
                if (i < priorities.length - 1) {
                    prioritiesNum = prioritiesNum.concat("%s. %s, ".formatted(i+1, priorities[i]));
                } else if (i == priorities.length - 1) {
                    prioritiesNum = prioritiesNum.concat("%s. %s".formatted(i+1, priorities[i]));
                }
            }
            System.out.println(prioritiesNum);
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            try {
                if (input <= priorities.length) {
                    for (int i = 0; i < priorities.length; i++) {
                        if (input == i+1) {
                            task.setPriority(priorities[i]);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(" ");
                System.out.println("Please choose only from priority list.");
            }
        }

    private static void inputDate(Task task) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("Enter deadline of task.");
            System.out.println("Example : yyyy-MM-dd");
            String input = scanner.nextLine().trim();

            try {
                LocalDate date = LocalDate.parse(input, formatter);
                task.setDeadLine(date);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
    }
}

