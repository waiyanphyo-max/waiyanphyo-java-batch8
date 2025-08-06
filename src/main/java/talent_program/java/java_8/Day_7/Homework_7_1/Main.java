package main.java.talent_program.java.java_8.Day_7.Homework_7_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = getStudents();

        for (Student student : students) {
            System.out.println(" ");
            System.out.println("Id      : " + student.getId());
            System.out.println("Name    : " + student.getName());
        }

        studentInfo(students, "Maung");

        System.out.println(" ");
        System.out.printf("There are %d students%n", students.size());

        removeStudent(students,6);

        System.out.println(" ");
        System.out.printf("There are %d students%n", students.size());

    }

    static void removeStudent(ArrayList<Student> students, int id) {

        students.removeIf(student -> student.getId() == id);
        System.out.println(" ");
        System.out.printf("Student with id - %d is removed%n", id);

    }

    static void studentInfo(ArrayList<Student> students, String name) {

        students.stream()
                .filter(student -> student.getName().equals(name))
                .findFirst()
                .ifPresentOrElse(student -> {
                            System.out.println(" ");
                            System.out.printf("Here is %s's info.%n", name);
                            System.out.println("Id       : "+student.getId());
                            System.out.println("Name     : "+student.getName());
                        }, () -> {
                            System.out.println("There is no student with name of "+name);
                        }
                );
    }

    static ArrayList<Student> getStudents() {
        Student student1 = new Student(1, "Maung");
        Student student2 = new Student(2, "Nyein Maung");
        Student student3 = new Student(3, "Khaing");
        Student student4 = new Student(4, "Hlaing");
        Student student5 = new Student(5, "Myaing");
        Student student6 = new Student(6, "Tin Maung Nyunt");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        return students;
    }
}

