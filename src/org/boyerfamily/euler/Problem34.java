package org.boyerfamily.euler;

/**
 * Project Euler, Problem 34
 *
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 *
 * Note: As 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Problem34 {
    static private int[] factorials = {0,1,2,6,24,120,720,5040,40320,362880}; // fifths
    static int total = 0;

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < 10; m++) {
                            for (int n = 0; n < 10; n++) {
                                for (int p = 0; p < 10; p++) {
                                    for (int q = 0; q < 10; q++) {
                                        int sum = factorials[i] + factorials[j] + factorials[k] + factorials[l] +
                                                factorials[m] + factorials[n] + factorials[p] + factorials[q];
                                        int places = (i * 10000000) + (j * 1000000) + (k * 100000) + (l * 10000) +
                                                (m * 1000) + (n * 100) + (p * 10) + q;
                                        if (sum == places) {
                                            //                                    System.out.printf("(%d, %d, %d, %d, %d, %d) ", i, j, k, l, m, n);
                                            //                                    System.out.printf("(%d, %d, %d, %d, %d, %d) ", factorials[i], factorials[j], factorials[k], factorials[l], factorials[m], factorials[n]);
                                            System.out.printf("Found one: (%d, %d)\n", sum, places);
                                            total += sum;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Subtract three from this for the 1 & 2 result
        System.out.println("Total is: " + total);
    }
}
