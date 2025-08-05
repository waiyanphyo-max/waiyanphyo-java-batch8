package main.java.talent_program.java.java_8.Day_4.HomeWork_4_1;

public class Student extends Person{
    private int gradeLevel;

    public Student(String name, int age) {
        super(name, age);
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    @Override
    public void introduce(String name, int age) {
        System.out.printf("My name is %s and I'm grade %s%n", name, age);
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
