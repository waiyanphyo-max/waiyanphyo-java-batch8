package main.java.talent_program.java.java_8.Day_1_to_3;

import java.util.Scanner;

public class PrintingTable_3_4 { // 3.4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        printTable(number, 12);
    }

    static void printTable(int number, int row) {
        for(int i = 0; i< row; i++) {
            System.out.printf("%s x %s = %s%n", number, i+1, (number * i+1));
        }
    }
}
