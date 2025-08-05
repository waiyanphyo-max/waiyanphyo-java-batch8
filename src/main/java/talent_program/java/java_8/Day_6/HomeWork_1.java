package main.java.talent_program.java.java_8.Day_6;

import java.util.Scanner;

public class HomeWork_1 {
    public static void main(String[] args) {
        int result = divide();
        System.out.println("result  : "+result);
    }

    static int divide() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter what you want to calculate");
            System.out.println("Example : 4 / 2");
            String input = sc.nextLine();
            String[] arrays = input.split(" / ");
            int a = 0;
            int b = 0;
            try {
                a = Integer.parseInt(arrays[0]);
                b = Integer.parseInt(arrays[1]);
            } catch (NumberFormatException e) {
                System.out.println("Please just type numbers.");
                return 0;
            }
            return a/b;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
            System.out.println(-1);
            return -1;
        }
    }
}
