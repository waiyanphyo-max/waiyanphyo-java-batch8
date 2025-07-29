package main.java.talent_program.java.java_8;

import java.util.Scanner;

public class MyIcon {
    public static void main(String[] args) {
        System.out.println("Enter a symbol");
        Scanner sc = new Scanner(System.in);
        String symbol = sc.next();
        System.out.println("Enter a number");
        int num = sc.nextInt();
        System.out.println(symbol.repeat(num));
    }
}
