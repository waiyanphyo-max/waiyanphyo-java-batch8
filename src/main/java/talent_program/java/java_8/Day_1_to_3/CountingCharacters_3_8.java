package main.java.talent_program.java.java_8.Day_1_to_3;

import java.util.Scanner;

public class CountingCharacters_3_8 { // 3.8
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        count(text);
        sc.close();
    }

    static void count(String input) {
        int letters = 0;
        int numbers = 0;
        int specials = 0;

        for(int i=0; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))) {
                letters++;
            } else if (Character.isAlphabetic(input.charAt(i))) {
                numbers++;
            } else if (!Character.isSpaceChar(input.charAt(i))) {
                specials++;
            }
        }

        System.out.printf("Your input text has %s letters, %s numbers and %s special characters%n", letters, numbers, specials);
    }
}
