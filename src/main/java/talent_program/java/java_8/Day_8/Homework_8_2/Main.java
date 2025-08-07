package main.java.talent_program.java.java_8.Day_8.Homework_8_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IntegerPrinting();

        doublePrinting();
    }

    private static void doublePrinting() {

        Printer<Double> doublePrinter = new Printer<>();

        System.out.println("Enter Double values to add.");
        System.out.println("Example : 1.11,3.33,4.33,5.02,6.40");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] arrays = input.split(",");

        for (String string : arrays) {
            Double doubleValue = null;
            try {
                doubleValue = Double.parseDouble(string);
            } catch (NumberFormatException e) {
                System.out.println("Only numbers can calculated.");
                continue;
            }
            doublePrinter.add(doubleValue);
        }

        System.out.println(" ");
        doublePrinter.printAll();
    }

    private static void IntegerPrinting() {

        Printer<Integer> integerPrinter = new Printer<>();

        System.out.println("Enter Integer values to add.");
        System.out.println("Example : 1,3,4,5,6");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] arrays = input.split(",");

        for (String string : arrays) {
            Integer intValue = null;
            try {
                intValue = Integer.parseInt(string);
            } catch (NumberFormatException e) {
                System.out.println("Only numbers can calculated.");
                continue;
            }
            integerPrinter.add(intValue);
        }

        System.out.println(" ");
        integerPrinter.printAll();
    }
}

