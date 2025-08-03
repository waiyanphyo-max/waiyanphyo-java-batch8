package main.java.talent_program.java.java_8.HomeWork_4_2;

public abstract class Animal {
    private String name;
    private int age;

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

    abstract void makeSound();

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo(String name, int age) {
        System.out.println("name : "+name);
        System.out.println("age : "+age);
    }


    public void feed(String food) {
        System.out.println("Animal are eating.");
    }
}
