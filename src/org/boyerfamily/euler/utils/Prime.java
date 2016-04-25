package org.boyerfamily.euler.utils;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;

/**
 * This is a collection of utility methods having to do with prime numbers.
 *
 * Created by : aboyer (5/1/12 4:40 PM)
 */
public class Prime {
    /**
     * Hugely brute force, and leading to O(n^2) performance.  Come back and optimize later.
     *
     * @param candidate Number to be tested.
     * @return True if input is prime, false otherwise.
     */
    public static boolean isPrime(long candidate) {
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
