package main.java.talent_program.java.java_8.Day_8.Homework_8_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Printer<Integer> integerPrinter = new Printer<>();

        integerPrinter.add(1);
        integerPrinter.add(2);
        integerPrinter.add(3);
        integerPrinter.add(4);
        integerPrinter.add(5);

        System.out.println(" ");
        integerPrinter.printAll();

        Printer<Double> doublePrinter = new Printer<>();

        doublePrinter.add(3.00);
        doublePrinter.add(5.39);
        doublePrinter.add(33.20);
        doublePrinter.add(00.43);
        doublePrinter.add(420.29);

        System.out.println(" ");
        doublePrinter.printAll();
    }
}
