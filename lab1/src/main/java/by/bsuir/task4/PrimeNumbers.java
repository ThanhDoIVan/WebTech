package by.bsuir.task4;

import java.math.BigInteger;

public class PrimeNumbers {
    private PrimeNumbers() {}

    public static void main(String[] args) {
        int[] array = new int[] {3, 2, 4, 12, 5};
        PrimeNumbers.printPrimeNumbersIndexes(array);
    }

    public static void printPrimeNumbersIndexes(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(isPrimeNumber(array[i]) ? i + " " : "");
        }
    }

    private static boolean isPrimeNumber(int number) {
        return BigInteger.valueOf(number).isProbablePrime((int) Math.log(number));
    }
}
