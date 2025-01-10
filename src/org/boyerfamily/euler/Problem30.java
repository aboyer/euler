package org.boyerfamily.euler;

/**
 * Project Euler, Problem 30
 *
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 *
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4 = 1 + 1296 + 91 + 256
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4 = 16 +
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * As 1 = 14 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class Problem30 {
//    static private int[] powers = {0,1,16,81,256,625,1296,2401,4096,6561}; // fourths
    static private int[] powers = {0,1,32,243,1024,3125,7776,16807,32768,59049}; // fifths
    static int total = 0;

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < 10; m++) {
                            for (int n = 0; n < 10; n++) {
                                int sum = powers[i] + powers[j] + powers[k] + powers[l] + powers[m] + powers[n];
                                int places = (i * 100000) + (j * 10000) + (k * 1000) + (l * 100) + (m * 10) + n;
                                if (sum == places) {
                                    System.out.printf("(%d, %d, %d, %d, %d, %d) ", i, j, k, l, m, n);
                                    System.out.printf("(%d, %d, %d, %d, %d, %d) ", powers[i], powers[j], powers[k], powers[l], powers[m], powers[n]);
                                    System.out.printf("Found one: (%d, %d)\n", sum, places);
                                    total += sum;
                                }
                            }
                        }
                    }
                }
            }
        }

        // Subtract one from this for the 1 result
        System.out.println("Total is: " + total);
    }
}
