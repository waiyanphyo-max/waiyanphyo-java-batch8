package main.java.talent_program.java.java_8;

import java.util.Arrays;
import java.util.Scanner;

public class BMICalculationInBritish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your weight in Pounds");
        double weight = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter Your Height in Feet and Inches");
        System.out.println("Example:: 5' 10\" ");
        String input = sc.nextLine();
        String height = input.replace("'", "").replace("\"", "");
        String[] heightArray = height.split(" ");
        double feet = Double.parseDouble(heightArray[0]);
        double inches = Double.parseDouble(heightArray[1]);
        double totalInches = (feet * 12) + inches;
        double result = (weight/(totalInches*totalInches))*703;
        double BMI = (double) Math.round(result * 100) /100;
        System.out.println("Your BMI is " + BMI);

        if(BMI < 18.5) {
            System.out.println("Your BMI is Underweight");
        } else if (BMI >= 18.5 && BMI < 25) {
            System.out.println("Your BMI is Normal weight");
        } else if (BMI >= 25 && BMI <30) {
            System.out.println("Your BMI is Overweight");
        } else {
            System.out.println("Your BMI is Obese");
        }
        sc.close();
    }
}