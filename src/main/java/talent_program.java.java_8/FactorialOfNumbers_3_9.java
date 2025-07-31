package main.java.talent_program.java.java_8;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialOfNumbers_3_9 { // 3.9
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        System.out.printf("Factorial of %s is %s%n", number, factorial(number));
    }

    static BigInteger factorial(long input) {

        BigInteger result = BigInteger.ONE;
        for(long i = 1; i <= input; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
