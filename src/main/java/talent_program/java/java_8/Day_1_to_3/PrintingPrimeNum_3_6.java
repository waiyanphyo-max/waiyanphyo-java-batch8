package main.java.talent_program.java.java_8.Day_1_to_3;

public class PrintingPrimeNum_3_6 { // 3.6
    public static void main(String[] args) {
        String primeNumbers = "";
        for (int i = 1; i <= 100; i++) {
            if(primeNumbers.isEmpty() && isPrime(i)) {
                primeNumbers = primeNumbers.concat("%s".formatted(i));
            } else if (!primeNumbers.isEmpty() && isPrime(i)) {
                primeNumbers = primeNumbers.concat(", %s").formatted(i);
            }
        }
        System.out.println("Prime numbers between 1 and 100 are " + primeNumbers);
    }

    static boolean isPrime(int a) {

        if(a <= 1) return false;
        if(a == 2) return true;
        if(a % 2 == 0) return false;

        for(int i = 3; i <= a-1; i +=2) {
            if (a % i == 0) return false;
        }
        return true;
    }
}
