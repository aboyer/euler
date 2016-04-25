package org.boyerfamily.euler;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 *   Evaluate the sum of all the amicable numbers under 10000.
 *
 * Created by aboyer on 4/24/16.
 */
public class Problem21 {
    // First, create an array of the sum of the proper divisors for each number 1-10000
    private static final int UPPER_BOUND = 10000;
    private static int sums[] = new int[UPPER_BOUND+1];

    public static void main(String[] args) {
        for (int i=1; i<=UPPER_BOUND; i++) {
            sums[i] = sum_of_proper_divisors(i);
//            System.out.printf("Sum for %d was: %d\n", i, sums[i]);
        }

//        System.out.println("Last sum was: " + Integer.toString(sums[UPPER_BOUND-1]));

        int sum_of_all = 0;
        // Should 1 be counted, and if so once or twice?
        for (int i=1; i<=UPPER_BOUND; i++) {
            int cur_sum = sums[i];
//            System.out.printf("Checking amicable numbers %d and %d\n", i, cur_sum);
            if (cur_sum <= UPPER_BOUND && cur_sum != i && sums[cur_sum] == i) {
                sum_of_all += i;
                System.out.printf("Found amicable numbers %d and %d, total is %d\n", i, cur_sum, sum_of_all);
            }
        }
        System.out.println("Total sum was: " + Integer.toString(sum_of_all));
    }

    private static int sum_of_proper_divisors(int input) {
        int current = 1; // Everything is divisible by one
        for (int i=input/2+1; i>1; i--) {
            if (input % i == 0)
                current += i;
        }
        return current;
    }
}
