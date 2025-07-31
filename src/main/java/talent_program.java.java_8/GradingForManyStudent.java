package main.java.talent_program.java.java_8;

import java.util.Scanner;

public class GradingForManyStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to check for how many students");
        int students = sc.nextInt();

        String input = "Yes";
        int i = 0;

        do {
            System.out.println("Enter marks of Physics for student %s".formatted(i+1));
            int phys = sc.nextInt();
            System.out.println("Enter marks of Chemistry for student %s".formatted(i+1));
            int chem = sc.nextInt();
            System.out.println("Enter marks of Biology for student %s".formatted(i+1));
            int bio = sc.nextInt();
            int total = phys + chem + bio;
            double average = (double) total /3;

            if(average <= 100 && average >= 90) {
                System.out.println("Student %s is Grade A".formatted(i+1));
            } else if (average < 90 && average >= 80) {
                System.out.println("Student %s is Grade B".formatted(i+1));
            } else if (average < 80 && average >= 70) {
                System.out.println("Student %s is Grade C".formatted(i+1));
            } else if (average < 70 && average >=60) {
                System.out.println("Student %s is Grade D".formatted(i+1));
            } else {
                System.out.println("Student %s is Grade F".formatted(i+1));
            }

            System.out.println("Do you want to continue for student %s".formatted(i+2));
            input = sc.next();
            i++;

        } while (input.equalsIgnoreCase("Yes"));

        sc.close();
    }
}
