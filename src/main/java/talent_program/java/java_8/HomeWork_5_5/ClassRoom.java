package main.java.talent_program.java.java_8.HomeWork_5_5;

import java.util.ArrayList;

public class ClassRoom {
    public static void main(String[] args) {
        final var studentList = getStudents();
        final var teacherList = getTeachers();

        Student[] students = studentList.toArray(new Student[0]);
        Teacher[] teachers = teacherList.toArray(new Teacher[0]);

        for (Student student : students) {
            System.out.println(" ");
            System.out.println(student.toString());
        }

        for (Teacher teacher : teachers) {
            System.out.println(" ");
            teacher.goForTeach();
            System.out.println(" ");
            teacher.teach("Physics");
        }
    }

    private static ArrayList<Teacher> getTeachers() {
        Teacher teacher1 = new Teacher();
        teacher1.setName("U Ba");
        teacher1.setAge(39);
        teacher1.setSubject("Physics");

        Teacher teacher2 = new Teacher();
        teacher2.setName("Daw Mya");
        teacher2.setAge(45);
        teacher2.setSubject("Chemistry");

        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);

        return teachers;
    }

    private static ArrayList<Student> getStudents() {
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Mg Mg");
        student1.setAge(19);
        student1.setGrade(11);

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Aye Aye");
        student2.setAge(17);
        student2.setGrade(9);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        return students;
    }
}
