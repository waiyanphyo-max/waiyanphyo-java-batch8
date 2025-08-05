package main.java.talent_program.java.java_8.Day_4.HomeWork_4_1;

public class Person {
    private String name;
    private int age;
    private String role;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void introduce(String name, int age) {
        System.out.println("Hello every one.");
    }

    public String getRole() {
        return role;
    }
}
