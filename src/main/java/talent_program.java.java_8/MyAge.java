package main.java.talent_program.java.java_8;

import java.util.Scanner;

public class MyAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your birth year");
        int dob = sc.nextInt();
        System.out.println("Your age is %s".formatted(2025 - dob));
    }
}
