package org.boyerfamily.euler;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;

/**
 * Project Euler, Problem 10:
 *  The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 *  Find the sum of all the primes below two million.
 *
 * Created by : aboyer (5/7/12 12:12 AM)
 */
public class Problem10 {
    public static final int LIMIT=2000000;

    public static void main(String[] args) {
        long sum = 0;
        long prime = 2;

        while (prime < LIMIT) {
            sum += prime;
            prime = getNextPrime(prime);
        }

        System.out.printf("Sum of all primes less than %d is %d\n",LIMIT,sum);
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
        if (candidate == 2)
            return true;

        if (candidate < 2 || candidate % 2 == 0) // The only even prime is 2
            return false;


        long limit = round(sqrt(candidate));
        for (long l = 3; l<= limit; l+=2) {
            if (candidate%l == 0)
                return false;
        }

        return true;
    }
}
