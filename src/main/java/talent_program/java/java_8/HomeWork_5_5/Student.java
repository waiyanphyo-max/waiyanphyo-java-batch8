package main.java.talent_program.java.java_8.HomeWork_5_5;

public class Student extends Person{
    private int id;
    private int grade;

    public Student(String name, int age) {
        super(name, age);
    }

    public Student() {
        super();
    }

    public void study() {
        System.out.println("Student is studying");
    }

    public void study(String subject) {
        System.out.printf("%s is studying %s%n", super.getName(), subject);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                "name" + super.getName() +
                "age" + super.getAge() +
                ", grade=" + grade +
                '}';
    }
}
