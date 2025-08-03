package main.java.talent_program.java.java_8.HomeWork_4_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Zoo {
    public static void main(String[] args) {
        final var arrayList = getAnimals();

        Animal[] animals = arrayList.toArray(new Animal[0]);

        for (Animal animal : animals) {
            System.out.println(" ");
            animal.displayInfo(animal.getName(), animal.getAge());
            animal.makeSound();

            if(animal instanceof Elephant elephant) {
                elephant.feed("Cane");
            } else if (animal instanceof Lion lion) {
                lion.feed("Meet");
            }
        }
    }

    private static ArrayList<Animal> getAnimals() {
        Lion lion = new Lion("KayThaYarZar", 6);
        Elephant elephant = new Elephant("Sad dan", 13);

        ArrayList<Animal> arrayList = new ArrayList<>();
        arrayList.add(lion);
        arrayList.add(elephant);

        return arrayList;
    }
}
