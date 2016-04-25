package org.boyerfamily.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Collator;
import java.util.Arrays;
import java.util.TreeSet;

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
 * Analysis: 9! is 362,880.  The first digit increments because of the order, so I know the first number
 * starting with 2 should be the 725,761st number.  Question is, do we analyze the rest of the digits like that?
 * Created by : aboyer (12/21/12 20:45)
 */
public class Problem24 {
    public static void main(String[] args) {
        TreeSet<Integer> factorials = new TreeSet<Integer>(Arrays.asList(1,1,2,6,24,120,720,5040,40320,362880));
        TreeSet<Integer> digits = new TreeSet<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
//        int start =
        int count = digits.size();
        int remaining = 1000000;
        StringBuffer str = new StringBuffer("");

        for (int i=0; i<=count; i++) {
            System.out.println(i + "! = " + factorial(i));

        }
    }

    private static int factorial(int n) {
            int fact = 1; // this  will be the result
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            return fact;
    }
}
