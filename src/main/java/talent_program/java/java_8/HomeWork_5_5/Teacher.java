package main.java.talent_program.java.java_8.HomeWork_5_5;


public class Teacher extends Person implements AbleToGo{
    private String subject;

    public Teacher() {
        super();
    }

    public void teach() {
        System.out.println("Mr. Smith is teaching Math.");
    }

    public void teach(String subject) {
        System.out.printf("%s is teaching %s%n", super.getName(), subject);
    }

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
    public void goForTeach() {
        System.out.printf("%s is going to teach %s%n", super.getName(), subject);
    }
}
