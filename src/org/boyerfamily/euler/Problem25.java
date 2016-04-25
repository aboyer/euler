package org.boyerfamily.euler;

import java.math.BigInteger;

/**
 * Project Euler, Problem 20:
 *
 * The Fibonacci sequence is defined by the recurrence relation:

 Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.
 Hence the first 12 terms will be:

 F1 = 1
 F2 = 1
 F3 = 2
 F4 = 3
 F5 = 5
 F6 = 8
 F7 = 13
 F8 = 21
 F9 = 34
 F10 = 55
 F11 = 89
 F12 = 144
 The 12th term, F12, is the first term to contain three digits.

 What is the first term in the Fibonacci sequence to contain 1000 digits?
 *
 * Created by : aboyer (12/21/12 20:45)
 */
public class Problem25 {
    public static void main(String[] args) {
        int term = 2;
        int digitCount = 1;
        BigInteger first = BigInteger.ONE;
        BigInteger second = BigInteger.ONE;

        while (term < 10000 && digitCount < 1000)  {
            term++;
            BigInteger next = nextFib(first,second);
            if (term>4500)
                digitCount = next.toString().length();
            first = second;
            second = next;
        }


        System.out.printf("Term %d has %d digits\n",term,digitCount);
    }

    public static BigInteger nextFib(BigInteger one, BigInteger two) {
        return one.add(two);
    }
}
