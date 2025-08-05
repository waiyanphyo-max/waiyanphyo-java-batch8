package main.java.talent_program.java.java_8.Day_4.HomeWork_4_2;

public class Elephant extends Animal{

    public Elephant(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Pawoooooo!  Brrrrr-rrrrr!");
    }

    @Override
    public void feed(String food) {
        System.out.println(this.getName()+" is eating %s.".formatted(food));
    }
}
