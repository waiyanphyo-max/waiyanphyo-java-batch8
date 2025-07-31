package main.java.talent_program.java.java_8;

import java.util.Scanner;

public class MethodOverloading_3_2 { // 3.2
    public static void main(String[] args) {
        greet();
        System.out.println("What is your name?");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        greet(name);
    }

    static void greet() {
        System.out.println("Hello!");
    }

    static void greet(String name) {
        System.out.println("Hello, %s!".formatted(name));
    }
}
