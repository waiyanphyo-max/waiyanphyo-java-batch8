package main.java.talent_program.java.java_8.Day_8.Homework_8_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1. Sum");
        System.out.println("2. Find Average");
        System.out.println("3. Find Minimum");
        System.out.println("4. Find Maximum");
        System.out.println("5. Exit");

        int input = sc.nextInt();

        while (true) {
            if (input == 1) {
                System.out.println(" ");
                sum();
                System.out.println(" ");
                System.out.println("What do you want to do?");
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
            } else if (input == 2) {
                System.out.println(" ");
                average();
                System.out.println(" ");
                System.out.println("What do you want to do?");
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
            } else if (input == 3) {
                System.out.println(" ");
                findMinValue();
                System.out.println(" ");
                System.out.println("What do you want to do?");
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
            } else if (input == 4){
                System.out.println(" ");
                findMaxValue();
                System.out.println(" ");
                System.out.println("What do you want to do?");
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
            } else if (input == 5) {
                System.out.println("Exiting.....");
                break;
            } else {
                System.out.println("Please choose within 1 to 5.");
                System.out.println("Exiting.....");
                break;
            }
        }
    }

    private static void findMinValue() {
        ArrayList<Integer> integers = getIntegers();

        Integer[] intArrays = integers.toArray(new Integer[0]);

        int minValue = Integer.MAX_VALUE;
        for (Integer integer : intArrays) {
            if(integer < minValue) {
                minValue = integer;
            }
        }

        System.out.printf("The minimum number of %s is %s%n", Arrays.toString(intArrays), minValue);
    }

    private static void findMaxValue() {

        ArrayList<Integer> integers = getIntegers();

        Integer[] intArrays = integers.toArray(new Integer[0]);

        int maxValue = Integer.MIN_VALUE;
        for (Integer integer : intArrays) {
            if(integer > maxValue) {
                maxValue = integer;
            }
        }

        System.out.printf("The maximum number of %s is %s%n", Arrays.toString(intArrays), maxValue);
    }

    private static void average() {

        ArrayList<Integer> integers = getIntegers();

        Integer[] intArrays = integers.toArray(new Integer[0]);

        double result = (double) sum(intArrays) / intArrays.length;

        double average = Math.round(result * 100 / 100);

        System.out.printf("The average number of %s is %s%n", Arrays.toString(intArrays), average);
    }

    private static int sum(Integer[] intArrays) {
        int result = 0;
        for (Integer intArray : intArrays) {
            result += intArray;
        }

        return result;
    }

    private static void sum() {

        ArrayList<Integer> integers = getIntegers();

        Integer[] intArrays = integers.toArray(new Integer[0]);

        int result = 0;
        for (Integer intArray : intArrays) {
            result += intArray;
        }

        System.out.printf("The total of %s is %s%n", Arrays.toString(intArrays), result);
    }

    private static ArrayList<Integer> getIntegers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type numbers.");
        System.out.println("Example : 1,2,3,4,5");
        String input = sc.nextLine();

        String[] arrays = input.split(",");

        ArrayList<Integer> integerList = new ArrayList<>();

        for (String string : arrays) {
            Integer intValue = null;
            try {
                intValue = Integer.parseInt(string);
            } catch (NumberFormatException e) {
                System.out.println("Only numbers can calculated.");
                continue;
            }
            integerList.add(intValue);
        }

        return integerList;
    }
}
