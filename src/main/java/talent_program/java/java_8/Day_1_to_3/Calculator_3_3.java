package main.java.talent_program.java.java_8.Day_1_to_3;

import java.util.Scanner;

public class Calculator_3_3 { //3.3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 or 3 numbers to multiply::");
        System.out.println("Example :: 4 * 3 or 4 * 3 * 2");

        String input = sc.nextLine();
        String[] inputArrays = input.split(" \\* ");

        int[] intArrays = new int[inputArrays.length];

        if(intArrays.length == 2) {
            for(int i=0; i<inputArrays.length; i++) {
                intArrays[i] = Integer.parseInt(inputArrays[i]);
            }
            System.out.println(multiply(intArrays[0], intArrays[1]));
        } else if (intArrays.length == 3){
            for(int i=0; i<inputArrays.length; i++) {
                intArrays[i] = Integer.parseInt(inputArrays[i]);
            }
            System.out.println(multiply(intArrays[0], intArrays[1], intArrays[2]));
        } else {
            System.out.println("Your typing is wrong!");
        }
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static int multiply(int a, int b, int c) {
        return a * b * c;
    }
}
