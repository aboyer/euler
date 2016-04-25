package org.boyerfamily.euler;

/**
 * Project Euler, Problem 17:
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 *
 *  NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen)
 *   contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 *
 * Created by aboyer on 4/24/16.
 */
public class Problem17 {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 1000;

    public static void main(String[] args) {
//        System.out.println("342 = " + Integer.toString(countLetters(342)));
//        System.out.println("115 = " + Integer.toString(countLetters(115)));
        int sum = 0;
        for (int i = START_NUMBER; i<= END_NUMBER; i++) {
            sum += countLetters(i);
            System.out.println("Running total= " + Integer.toString(sum));
        }
        System.out.println("Total letters were: " + Integer.toString(sum));
    }

    private static int countLetters(int input) {
        // Letter counts for 1-19 (plus zero, so we can use int as index)
        int first20Counts[] = { 0, 3, 3, 5, 4, 4, 3, 5, 5, 4,
                                3, 6, 6, 8, 8, 7, 7, 9, 8, 8};

        // Letter counts for tens (twenty, thirty, etc)
        int tensCounts[] = { 0, 0, 6, 6, 5, 5, 5, 7, 6, 6 };

        int hundredCount = 7;
        int andCount = 3;
        int current = input;
        int count = 0;

        // One thousand is a simple case, so we'll take care of that,
        // then we can count on only three digits or less.
        if (current == 1000)
            return 11;

        // Handle the hundreds place, then remove it
        if (current >= 100) {
            current = input % 100;
            int hundreds = (input - current) / 100;
            count += first20Counts[hundreds] + hundredCount;

            // Only need this if it's not an even 100
            if (current > 0)
                count += andCount;
        }

        // Should have 1-99 now.  1-19 are unique, and the rest are tens plus ones
        if (current < 20)
            count += first20Counts[current];
        else {
            int ones = current % 10;
            int tens = (current - ones) / 10;
            count += tensCounts[tens] + first20Counts[ones];
        }

        System.out.println("Input: " + Integer.toString(input) + ", output: " + Integer.toString(count));
        return count;
    }
}
