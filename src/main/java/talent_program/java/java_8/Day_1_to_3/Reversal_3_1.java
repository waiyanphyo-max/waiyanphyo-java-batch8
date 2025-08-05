package main.java.talent_program.java.java_8.Day_1_to_3;

import java.util.Scanner;

public class Reversal_3_1 {  // 3.1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter something");
        String input = sc.nextLine();
        System.out.println(reverse(input));

        sc.close();
    }

    public static String reverse(String text) {
        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i<text.length(); i++) {
            reversed.append(text.charAt(text.length()-1 -i));
        }
        return reversed.toString();
    }
}
