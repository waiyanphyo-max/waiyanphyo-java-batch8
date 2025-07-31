package main.java.talent_program.java.java_8;

import java.util.Scanner;

public class CountingCharacters_3_8 { // 3.8
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int numbers = countNum(text);
        int specials = countSpecial(text);
        int letters = text.length() - (numbers + specials);
        System.out.printf("Your input text has %s letters, %s numbers and %s special characters%n", letters, numbers, specials);
    }

    static int countNum(String input) {
        int count = 0;
        for (int i=0; i < input.length(); i++) {
            for (int j=0; j<=9; j++){
                if(String.valueOf(input.charAt(i)).equals(String.valueOf(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    static int countSpecial(String input) {
        int count = 0;
        char[] specialCharacters = {
                '!', '@', '#', '$', '%', '^', '&', '*', '(', ')',
                '-', '_', '=', '+', '{', '}', '[', ']', ':', ';',
                '"', '\'', '<', '>', ',', '.', '?', '/', '\\', '|', '~', '`'
        };
        for (int i=0; i < input.length(); i++) {
            for (int j=0; j< specialCharacters.length; j++) {
                if(String.valueOf(input.charAt(i)).equals(String.valueOf(specialCharacters[j]))) {
                    count++;
                }
            }
        }
        return count;
    }
}
