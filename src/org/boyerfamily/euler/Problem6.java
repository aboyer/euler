package org.boyerfamily.euler;

/**
 * Project Euler, Problem Six:
 *  The sum of the squares of the first ten natural numbers is,
 *  1^2 + 2^2 + ... + 10^2 = 385
 *
 *  The square of the sum of the first ten natural numbers is,
 *  (1 + 2 + ... + 10)^2 = 552 = 3025
 *
 *  Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum
 *  is 3025 - 385 = 2640.
 *
 *  Find the difference between the sum of the squares of the first one hundred natural numbers and the square of
 *  the sum.
 *
 * Created by : aboyer (5/1/12 11:30 PM)
 */
public class Problem6 {
    public static final int LIMIT = 100;

    public static void main(String[] args) {
        System.out.printf("Difference for limit %d is %d\n",LIMIT,sumOfSquares(LIMIT)-squareOfSums(LIMIT));
    }

    static int sumOfSquares(int limit) {
        int sum = 0;
        for (int i = 1; i<=limit; i++) {
            sum += i*i;
        }

        return sum;
    }

    static int squareOfSums(int limit) {
        int sum=(limit+1)*limit/2;

        return sum*sum;
    }
}
