package main.java.talent_program.java.java_8;

import java.util.Scanner;

public class CountingVowels_3_5 { // 3.5
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter something");
        String input = sc.nextLine();
        System.out.println(countVowels(input));
    }

    static int countVowels(String input) {
        String caseInsensitive = input.toLowerCase();
        char[] charArrays = caseInsensitive.toCharArray();
        String vowelsString = "";
        int j = 0;
        for(int i = 0; i<charArrays.length; i++) {
            if(charArrays[i] == 'a' || charArrays[i] == 'e' || charArrays[i] == 'i' || charArrays[i] == 'o' || charArrays[i] == 'u') {
                j++;
            }
        }
        return j;
    }
}
