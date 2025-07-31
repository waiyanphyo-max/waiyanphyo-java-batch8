package main.java.talent_program.java.java_8;

import java.util.Scanner;

public class Transaction {

    static double current_balance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your balance");

        current_balance = sc.nextDouble();

        int choice = 0;

        do {
            System.out.println("Choose that you want to do");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            sc.nextLine();
            System.out.println("Enter a number that belong to that you want to");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Enter an amount to deposit");
                double dep_amount = sc.nextDouble();
                current_balance = current_balance + dep_amount;
                System.out.println("************************************************");
                System.out.println("************************************************");
            }
            if (choice == 2) {
                System.out.println("Enter an amount to withdraw");
                double draw_amount = sc.nextDouble();
                if(draw_amount <= current_balance) {
                    current_balance = current_balance - draw_amount;
                } else {
                    System.out.println("You don't have enough balance");
                }
                System.out.println("************************************************");
                System.out.println("************************************************");
            }
            if (choice == 3) {
                System.out.println("Your balance is " + current_balance);
                System.out.println("************************************************");
                System.out.println("************************************************");
            }

        }while (choice < 4);

        sc.close();
    }
}
