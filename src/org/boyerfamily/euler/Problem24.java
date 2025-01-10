package org.boyerfamily.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Collator;
import java.util.*;

/**
 * Project Euler, Problem 24:
 *
 * Lexicographic permutations
 *
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the
 * digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it
 * lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 *  012   021   102   120   201   210
 *
 *  What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 *
 * Analysis: 9! is 362,880.  The first digit increments because of the order, so I know 2013456789 should be the
 * 725,761st number (2 * 9! + 1).  Question is, do we analyze the rest of the digits like that?
 * Created by : aboyer (12/21/12 20:45)
 */
public class Problem24 {
    public static void main(String[] args) {
        int[] factorials = {1, 1,2,6,24,120,720,5040,40320,362880,3628800};
        ArrayList<Character> digits = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        int digitCount = digits.size();
        int targetPermutation = 1000000-1;
        StringBuilder answer = new StringBuilder("");

        for (int place = digitCount-1; place >= 0; place--) {
            System.out.println("factorials[place]: " + factorials[place]);
            System.out.println("target: " + targetPermutation);
            if (targetPermutation >= factorials[place]) {
                int currentDigit = targetPermutation / factorials[place];
                targetPermutation -= currentDigit * factorials[place];
                System.out.println("target now: " + targetPermutation + ", currentDigit: " + currentDigit + ", digit: " + digits.get(currentDigit));
                answer.append(digits.get(currentDigit));
                digits.remove(currentDigit);
            } else {
                System.out.println("adding " + digits.get(0));
                answer.append(digits.get(0));
                digits.remove(0);
            }
        }
        System.out.printf("Final answer %s\n", answer);
    }
// 1000000: [2, 7, 8, 5, 9, 6, 0, 3, 4, 1]

    private static int factorial(int n) {
            int fact = 1; // this  will be the result
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            return fact;
    }
}
