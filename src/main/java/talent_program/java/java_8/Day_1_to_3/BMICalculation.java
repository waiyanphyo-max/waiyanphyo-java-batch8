package main.java.talent_program.java.java_8.Day_1_to_3;

import java.util.Scanner;

public class BMICalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your weight in Kilograms");
        double weight = sc.nextDouble();
        System.out.println("Enter Your height in Meters");
        double height = sc.nextDouble();
        double result = weight/(height*height);
        double BMI = (double) Math.round(result * 100) /100;
        System.out.println("Your BMI is " + BMI);

        if (BMI < 18.5) {
            System.out.println("Your BMI is Underweight");
        } else if (BMI >= 18.5 && BMI < 25) {
            System.out.println("Your BMI is Normal weight");
        } else if (BMI >=25 && BMI < 30) {
            System.out.println("Your BMI is Overweight");
        } else {
            System.out.println("Your BMI is Obese");
        }
        sc.close();
    }
}
