package org.boyerfamily.euler;

/**
 * Project Euler, Problem 1:
 *   If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these
 *   multiples is 23.
 *
 *   Find the sum of all the multiples of 3 or 5 below 1000.
 * 233168
 * Created by: aboyer (5/1/12 11:03 AM)
 */
public class Problem1 {
    public static void main(String[] args) {
        int sum = sumMultiples(10);
        assert sum == 23;

        System.out.println("Sum of multiples of 3 and 5, from 1 to 1000: " + sumMultiples(12));
    }

    static int sumMultiples(int limit) {
        limit--;
        int sum = limit >= 3 ? (sumOfRange(limit / 3) * 3) : 0;
        sum += limit >= 5 ? (sumOfRange(limit / 5) * 5) : 0;
        sum -= limit >= 15 ? (sumOfRange(limit / 15) * 15) : 0; // subtract the ones we double-counted.
        return sum;
    }

    static int sumOfRange(int max) {
        return max * (max+1) / 2;
    }
//        int sum = 0;
//        // First, let's do the simple implementation, looping through these numbers
//        // For purposes of this problem, I'm equating natural numbers to positive integers.
//
//        // First, validate the input.
//        if (limit < 1)
//            throw new IllegalArgumentException("Limit must be a positive integer.");
//
//        for (int i=1; i<limit; i++) {
//            if (i%3==0 || i%5==0)
//                sum += i;
//        }
//
//        return sum;
//    }
}
