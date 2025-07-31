package main.java.talent_program.java.java_8;


public class CountingPrimeNum_3_7 { // 3.7
    public static void main(String[] args) {
        int[] IntegerArrays = {1, 2, 4, 3, 5, 2, 7, 4, 0, 9, 11, 5, 20, 9, 384};
        System.out.printf("There are %s prime numbers in this Integer arrays.%n", countPrime(IntegerArrays));
    }

    static int countPrime(int[] intArrays) {
        int count = 0;
        for(int num : intArrays) {

            if(isPrime(num)) {
                count++;
            }
        }
        return count;
    }

    static boolean isPrime(int a) {

        if(a <= 1) return false;
        if(a == 2) return true;
        if(a % 2 == 0) return false;

        for(int i = 3; i <= Math.sqrt(a); i +=2) {
            if (a % i == 0) return false;
        }
        return true;
    }
}
