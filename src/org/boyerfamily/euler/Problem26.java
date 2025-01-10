package org.boyerfamily.euler;

import java.util.HashMap;

/**
 * Project Euler, Problem 26
 *
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
 *
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
class Problem26 {
    public static void main(String[] args) {
        int longestDivisor = 0;
        int longestRepeat = 0;

        for (int divisor = 2; divisor <= 1000; divisor++) {
            HashMap<Integer, Integer> remainders = new HashMap<>();
            int numerator = 10;
            int count = 0;

            StringBuilder answer = new StringBuilder();
            while (true) {
                while ((numerator < divisor)) {
                    numerator *= 10;
                }

                count++;
                answer.append(numerator / divisor);
                numerator %= divisor;
                if (remainders.containsKey(numerator)) {
                    int size = count - remainders.get(numerator);
                    System.out.printf("Divisor %d has repeat of size %d\n", divisor, size);
                    if (size > longestRepeat) {
                        longestDivisor = divisor;
                        longestRepeat = size;
                    }
                    break;
                }

                remainders.put(numerator, count);

                if (numerator == 0)
                    break;
            }
        }
        System.out.printf("Longest divisor %d, longest cycle %d\n", longestDivisor, longestRepeat);
    }
}