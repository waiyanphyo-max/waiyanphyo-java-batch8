package main.java.talent_program.java.java_8.HomeWork_4_1;

public class Teacher extends Person{
    String subject;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void introduce(String name, int age) {
        System.out.printf("My name is %s and I will teach you %s%n", name, subject);
    }

    @Override
    public String getRole() {
        return "Teacher";
    }
}
