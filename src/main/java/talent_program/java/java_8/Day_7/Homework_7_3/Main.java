package main.java.talent_program.java.java_8.Day_7.Homework_7_3;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> guests = new HashSet<>();

        guests.add("U Aung San");
        guests.add("U Nu");
        guests.add("U Than Htun");
        guests.add("U Soe");
        guests.add("U Ko Taw Hmaing");
        guests.add("U Nu");

        System.out.println(" ");
        for (String guest : guests) {
            System.out.println(guest);
        }

        System.out.println(" ");
        check(guests, "U Than Htun");

        System.out.println(" ");
        remove(guests, "U Soe");

        System.out.println(" ");
        System.out.println("The guests who remained are :");
        for (String guest : guests) {
            System.out.println(guest);
        }
    }

    static void check(HashSet<String> guests, String name) {
        if(guests.contains(name)) {
            System.out.printf("%s is exist.", name);
        } else {
            System.out.println("There is no guest with name = "+name);
        }
    }

    static void remove(HashSet<String> guests, String name) {
        if(guests.contains(name)) {
            guests.remove(name);
            System.out.println(" ");
            System.out.println("%s is removed.".formatted(name));
        } else {
            System.out.println("There is no guest with name = "+name);
        }
    }
}
