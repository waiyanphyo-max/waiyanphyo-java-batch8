package main.java.talent_program.java.java_8;

import java.util.Scanner;

public class Grading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks for English");
        int english = sc.nextInt();
        System.out.println("Enter marks for Mathematics");
        int math = sc.nextInt();
        System.out.println("Enter marks for Chemistry");
        int chem = sc.nextInt();
        System.out.println("Enter marks for Physics");
        int phys = sc.nextInt();
        System.out.println("Enter marks for Biology");
        int bio = sc.nextInt();
        int total = (english + math + chem + phys + bio);
        double average = (double) total / 5;
        System.out.println("Your average percentage is " + average);

        if(average <= 100 && average >= 90) {
            System.out.println("You are Grade A");
        } else if (average < 90 && average >= 80) {
            System.out.println("You are Grade B");
        } else if (average < 80 && average >= 70) {
            System.out.println("You are Grade C");
        } else if (average < 70 && average >=60) {
            System.out.println("You are Grade D");
        } else {
            System.out.println("You are Grade F");
        }
        sc.close();
    }
}
