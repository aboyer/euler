package org.boyerfamily.euler;

import org.boyerfamily.euler.utils.Prime;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.ListIterator;

import static java.lang.Math.min;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;

/**
 * Project Euler, Problem 4:
 *   A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit
 *   numbers is 9009 = 91 99.
 *
 *   Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * Created by : aboyer (5/1/12 1:13 PM)
 */
public class Problem4 {
    public static void main(String[] args) {
        long num = 999 * 999; // The largest product of two numbers

        // Start at the top, since we're trying to find a max
        while (num > 0) {
            // First filter on palindromes, most numbers won't be one.
            if (isPalindrome(num)) {
                // Now, we need to decide if this number has two three digit factors
                long limit = min(999,num/2+1);
                long factor = getThreeDigitFactor(num,limit);
                if (factor > 0 && (num % (num/factor) == 0)) {
                    System.out.printf("Found factors (%d and %d) for palindrome number %d.",factor,num/factor,num);
                    System.exit(0);
                }
            }
            num--;
        }
    }

    static long getThreeDigitFactor(long number, long prevFactor) {
        long factor = prevFactor;

        while (factor > 1) {
            if (number % factor == 0) { // Does it have two factors?
                long secondFactor = number / factor;

                if (String.valueOf(secondFactor).length() > 3)
                    return 0;
                else
                    return secondFactor;
            }
            factor--;
        }

        return 0;
    }

    static boolean isPalindrome(long candidate) {
        int[] digits = longToDigits(candidate);

        for (int i=0, j=digits.length-1; i <= j; i++,j--) {
            if (digits[i] != digits[j])
                return false;
        }

        return true;
    }

    /**
     * This will convert a number to an array of its digits.
     * @param l The number to be converted
     * @return an array of integers, each representing a digit in the original number.
     */
    static int[] longToDigits(long l) {
        char[] charDigits=Long.toString(l).toCharArray();
        int[] digits=new int[charDigits.length];

        for (int p=0;p<charDigits.length;++p)
            digits[p]=charDigits[p]-'0';

        return digits;
    }
}
