package main.java.talent_program.java.java_8;

import java.util.Scanner;

public class SystemInput {
    public static void main(String[] args) {
        System.out.println("Enter your name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("My name is :" +name);

        System.out.println("Enter your age");
        int age = sc.nextInt();
        System.out.println("My name is %s and my age is %d".formatted(name, age));

    }
}
