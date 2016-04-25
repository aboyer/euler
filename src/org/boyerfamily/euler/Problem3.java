package org.boyerfamily.euler;

import java.util.ArrayList;
import java.util.ListIterator;
import static java.lang.Math.*;

/**
 * Project Euler, Problem 3:
 *   The prime factors of 13195 are 5, 7, 13 and 29.
 *
 *   What is the largest prime factor of the number 600851475143 ?
 *
 * Created by : aboyer (5/1/12 12:07 PM)
 */
public class Problem3 {
    public static void main(String[] args) {
        long factor = getLargestPrimeFactor(13195);
        assert factor == 29;

        long input = 600851475143L;
        factor = getLargestPrimeFactor(input);
        System.out.printf("The largest factor of the number %d is %d.",input,factor);
    }

    /**
     * Wrapper to solve problem.  We generate a list of primes less than half the input value (since 2 is the smallest
     * prime, the largest factor other than 2 should be input div 2).  Then, using that list, we test to see if each
     * @param input The number we're trying to find a factor for.
     * @return the largest prime factor, or 0 if none could be found.
     */
    static long getLargestPrimeFactor(long input) {
        long limit = round(sqrt(input));
        ArrayList<Long> primeList = getPrimes(limit);
        ListIterator<Long> iter = primeList.listIterator(primeList.size());

        while (iter.hasPrevious()) {
            long factor = iter.previous();
            if (input % factor == 0)
                return factor;
        }

        return 0;
    }

    /**
     * This function computes and returns an array of all prime numbers smaller than the limit parameter.
     *
     * @param limit The upper bounds of the prime number to be returned
     * @return An sorted array of ascending integers, representing the prime numbers up to the specified limit.
     */
    static ArrayList<Long> getPrimes(long limit) {
        ArrayList<Long> list = new ArrayList<Long>();

        list.add(2l);

        for (long l = 3; l<=limit; l+=2) {
            if (isPrime(l))
                list.add(l);
        }

        return list;
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
