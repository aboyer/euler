package org.boyerfamily.euler;

import java.math.BigInteger;

/**
 * Project Euler, Problem 20:
 *
 * n! means n  (n  1)  ...  3  2  1
 *
 * For example, 10! = 10  9  ...  3  2  1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 *
 * Created by : aboyer (12/21/12 20:45)
 */
public class Problem20 {
    public static void main(String[] args) {
        long factor = 100;
        BigInteger num = BigInteger.valueOf(factor--);

        while (factor > 0)  {
            num = num.multiply(BigInteger.valueOf(factor--));
        }

        String str = num.toString();
        char[] digits = str.toCharArray();
        long sum = 0;

        for (int i=0; i<digits.length; i++) {
            sum += (digits[i] - '0');
        }

        System.out.printf("%d! = %s\n",100,str);
        System.out.printf("Sum of the digits is %d\n",sum);
    }
}
