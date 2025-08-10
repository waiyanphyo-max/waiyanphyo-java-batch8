package main.java.talent_program.java.java_8.Day_9.StudentCli;

import main.java.talent_program.java.java_8.Day_9.TaskCli.Priority;
import main.java.talent_program.java.java_8.Day_9.TaskCli.Status;
import main.java.talent_program.java.java_8.Day_9.TaskCli.Task;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        final var studentList = new ArrayList<Student>();
        final var studentGrades = new HashMap<Integer, Integer>();

        System.out.println(" ");
        System.out.println("Do you already have an account.");
        System.out.println("Answer [Y]es or [N]o");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (Objects.equals(input, "Y")) {
            getListFromFile(studentList, studentGrades);
        } else {
            addStudents(studentList);
        }

        chooseWhatToDo(studentList, studentGrades);

    }

    private static void chooseWhatToDo(ArrayList<Student> studentList, HashMap<Integer, Integer> studentGrades) {
        Scanner scanner  = new Scanner(System.in);

        while (true) {
            System.out.println(" ");
            System.out.println("1. Add Students, 2. Add Grade, 3. View Students' Grades");
            System.out.println(" 4. View Class Average, 5. View Top Student, 6. Search Student by Name, 0. Exit");

            int input = scanner.nextInt();

            if (input == 1) {
                addStudents(studentList);
            } else if (input == 2) {
                addGrade(studentList, studentGrades);
            } else if (input == 3) {
                viewStudentsGrades(studentList, studentGrades);
            } else if (input == 4) {
                viewClassAverage(studentGrades);
            } else if (input == 5) {
                viewTopStudent(studentList, studentGrades);
            } else if (input == 6) {
                searchStudentByName(studentList);
            } else if (input == 0) {
                saveAndExit(studentList, studentGrades);
                break;
            }
        }
    }

    private static void saveAndExit(ArrayList<Student> students, HashMap<Integer, Integer> studentGrades) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a file to store your data.");
            System.out.println("Example  : C:\\users\\text");
            String input = sc.nextLine();
            String folder = input.replace("\\", "\\\\");
            String textFile = STR."\{folder}.txt";
            File myFile = new File(textFile);
            if (myFile.createNewFile()) {
                FileWriter myWriter = new FileWriter(textFile);
                for (Student student : students) {

                    for (Map.Entry<Integer, Integer> entry : studentGrades.entrySet()) {
                        if (student.getId() == entry.getKey()) {
                            myWriter.write(STR."""
                    Student{id=\{student.getId()}, name='\{student.getName()}', address='\{student.getAddress()}', grade=\{entry.getValue()}}
                    """);
                        }
                    }
                }
                myWriter.close();
                System.out.println(" ");
                System.out.println("File is written successfully");
                sc.close();
            } else {
                if (myFile.delete()) {
                    myFile = new File(textFile);
                    if (myFile.createNewFile()) {
                        FileWriter myWriter = new FileWriter(textFile);
                        for (Student student : students) {

                            for (Map.Entry<Integer, Integer> entry : studentGrades.entrySet()) {
                                if (student.getId() == entry.getKey()) {
                                    myWriter.write(STR."""
                    Student{id=\{student.getId()}, name='\{student.getName()}', address='\{student.getAddress()}', grade=\{entry.getValue()}}
                    """);
                                }
                            }
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

    private static void searchStudentByName(ArrayList<Student> studentList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Enter name of Student.");
        String input = scanner.nextLine();
        for (Student student : studentList) {
            if (Objects.equals(input, student.getName())) {
                System.out.println(student.toString());
            }
        }
    }

    private static void viewTopStudent(ArrayList<Student> studentList, HashMap<Integer, Integer> studentGrades) {
        int maxMark = Integer.MIN_VALUE;
        String name = "";

        for (Map.Entry<Integer, Integer> entry : studentGrades.entrySet()) {
            if (entry.getValue() > maxMark) {
                maxMark = entry.getValue();

                for (Student student : studentList) {
                    if (student.getId() == entry.getKey()) {
                        name = student.getName();
                    }
                }
            }
        }

        System.out.println(" ");
        System.out.printf("Top student in this class is %s with %s marks.%n", name, maxMark);
    }

    private static void viewClassAverage(HashMap<Integer, Integer> studentGrades) {
        int count = studentGrades.size();
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : studentGrades.entrySet()) {
            total += entry.getValue();
        }
        double average = (double) total / count;
        System.out.println(" ");
        System.out.printf("Class's average grade is %s%n", average);
    }

    private static void viewStudentsGrades(ArrayList<Student> studentList, HashMap<Integer, Integer> studentGrades) {

        System.out.println(studentGrades);

        Student[] students = studentList.toArray(new Student[0]);

        for (int i = 0; i < students.length; i++) {
            for (Map.Entry<Integer, Integer> entry : studentGrades.entrySet()) {
                String studentName = "";
                int mark = 0;

                if (students[i].getId() == entry.getKey()) {
                    if (students[i].getId() < students.length) {
                        System.out.printf("%s. %s%n ", students[i].getName(), entry.getValue());
                    } else {
                        System.out.printf("%s. %s%n", students[i].getName(), entry.getValue());
                    }
                }
            }
        }
    }


    private static void addGrade(ArrayList<Student> studentList, HashMap<Integer, Integer> studentGrades) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> grades = getGrades();
        String choice = "";

        do {
            StringBuilder students = new StringBuilder();
            for (Student student : studentList) {
                if (student.getId() < studentList.size()) {
                    students.append("%d. %s%n ".formatted(student.getId(), student.getName()));
                } else {
                    students.append("%d. %s%n".formatted(student.getId(), student.getName()));
                }
            }

            System.out.println("Choose student by id.");
            System.out.println(students);
            int idInput = scanner.nextInt();
            scanner.nextLine();

            Student selectedStudent = null;
            for (Student student : studentList) {
                if (student.getId() == idInput) {
                    selectedStudent  = student;
                    break;
                }
            }

            if (selectedStudent == null) {
                System.out.println("Invalid student Id.");
                continue;
            }

            System.out.println(" ");
            System.out.println("Choose grade marks by id.");
            grades.forEach((id, mark) -> System.out.printf("%d. %d%n", id, mark));

            int gradeInput = scanner.nextInt();
            scanner.nextLine();

            if (grades.containsKey(gradeInput)) {
                studentGrades.put(selectedStudent.getId(), grades.get(gradeInput));
                System.out.printf("%s is grade %d%n", selectedStudent.getName(), grades.get(gradeInput));
            } else {
                System.out.println("Invalid input.");
            }

            System.out.println("Do you want to add grades for more students? [Y]es (or) [N]o.");
            choice = scanner.nextLine();
                    
        } while (Objects.equals(choice, "Y"));
    }

    private static HashMap<Integer, Integer> getGrades() {
        final HashMap<Integer, Integer> grades = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            grades.put(i, i*10);
        }
        return grades;
    }

    public static void getListFromFile(ArrayList<Student> students, HashMap<Integer, Integer> studentsGrades) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a file in that stored students and their grades.");
            System.out.println("Example  : C:\\users\\text_file");
            String input = sc.nextLine();
            String textFile = input.replace("\\", "\\\\");
            String lastFile = textFile.concat(".txt");
            File myFile = new File(lastFile);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                Student student = new Student();
                String result = myReader.nextLine();
                String result1 = result.substring(result.indexOf("{") + 1, result.lastIndexOf("}"));

                String[] array = result1.split(", ");
                HashMap<String, String> hashMap = new HashMap<>();
                for (String string : array) {
                    String[] keyValue = string.split("=");
                    hashMap.put(keyValue[0], keyValue[1]);
                }
                student.setId(Integer.parseInt(hashMap.get("id")));
                student.setName(hashMap.get("name"));
                student.setAddress(hashMap.get("address"));
                studentsGrades.put(student.getId(), Integer.parseInt(hashMap.get("grade")));
                students.add(student);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong");
        }

    }

    private static void addStudents(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println(" ");
        System.out.println("Firstly you need to add students.");
        do {
            Student student = new Student();

            student.setId(students.size()+1);
            Scanner sc = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("Enter name");
            String name = sc.nextLine();
            student.setName(name);
            System.out.println(" ");
            System.out.println("Enter address");
            String address = sc.nextLine();
            student.setAddress(address);
            students.add(student);
            System.out.println("Do you want to add more students? [Y]es (or) [N]o");
            input = scanner.nextLine();
        } while (Objects.equals(input, "Y"));
    }
}
