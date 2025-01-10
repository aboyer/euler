package org.boyerfamily.euler;

import org.boyerfamily.euler.utils.Prime;

import static java.lang.Math.round;

/**
 * Project Euler, Problem 7:
 *  By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 *  What is the 10,001st prime number?
 *
 * Created by : aboyer (5/1/12 11:33 PM)
 */
public class Problem7 {
    public static final int LIMIT = 10001;

    public static void main(String[] args) {
        long prime = 0;
        long primeNumber = 0;

        while (++primeNumber <= LIMIT) {
            prime = getNextPrime(prime);
        }

        System.out.printf("Prime number %d is %d\n",LIMIT,prime);
    }

    static long getNextPrime(long start) {
        if (start<2)
            return 2;

        if (start==2)
            return 3;

        for (long l = start+2; true; l+=2) {
            if (isPrime(l))
                return l;
        }
    }

    /**
     * Hugely brute force, and leading to O(n^2) performance.  Come back and optimize later.
     *
     * @param candidate Number to be tested.
     * @return True if input is prime, false otherwise.
     */
    static boolean isPrime(long candidate) {
        return Prime.isPrime(candidate);
    }
}
