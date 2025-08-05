package main.java.talent_program.java.java_8.Day_1_to_3;

import java.util.Scanner;

public class MySquareBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a character");
        String character = sc.next();
        System.out.println("How many lines do you want to print");
        int line_count = sc.nextInt();
        for (int i = 0; i<line_count; i++) {
            System.out.println(character.repeat(line_count*3));
        }
        sc.close();
    }
}
