package main.java.talent_program.java.java_8;

import java.util.Scanner;
import java.util.ArrayList;

public class MyName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your name");
        String name = sc.nextLine();
        String noSpace = name.replace(" ", "");
        char[] charArray = noSpace.toCharArray();
        System.out.println("Each Letter of your name on a separate line is");
        for (int i=0; i<charArray.length; i++) {
            System.out.println(charArray[i]);
        }
    }
}
