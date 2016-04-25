package org.boyerfamily.euler;

import java.util.HashSet;
import java.util.Set;

/**
 * Project Euler, Problem 5:
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * Created by : aboyer (5/1/12 9:16 PM)
 */
public class Problem5 {
    public static final int LIMIT = 20;

    public static void main(String[] args) {
        Set<Long> set = new HashSet<Long>(LIMIT);
        for (long l = LIMIT; l>0; l--) {
            set.add(l);
        }

        boolean found = false;
        long num=19;

        while (!found) {
            found = true;
            num++;

            for (long test = LIMIT; test>0; test--) {
                if (num % test != 0) {
                    found = false;
                    break;
                }
            }
        }

        System.out.printf("Found number %d, divisible by 1..%d",num,LIMIT);
    }
}
