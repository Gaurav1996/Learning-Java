package com.gagrawal.practice.quick;

/**
 *    1
 *   121
 *  12321
 * 1234321
 */
public class PrintPattern {
    public static void main(String[] args) {
        int maxNumber = 10;
        printPattern(maxNumber);
    }

    private static void printPattern(int maxNumber) {
        int noOfSpaces = maxNumber - 1;
        while (noOfSpaces>=0) {
            for (int i = 0; i < noOfSpaces; i++) {
                System.out.print(" ");
            }
            int localMaxNumber = maxNumber - noOfSpaces;
            for (int i = 1; i <= localMaxNumber; i++) {
                System.out.print(i);
            }
            if(localMaxNumber>1) {
                int reverseNumber = localMaxNumber - 1;
                while (reverseNumber>=1) {
                    System.out.print(reverseNumber);
                    reverseNumber--;
                }
            }
            for (int i = 0; i < noOfSpaces; i++) {
                System.out.print(" ");
            }
            System.out.println();
            noOfSpaces--;
        }
    }
}
