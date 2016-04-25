package org.boyerfamily.euler;

import java.math.BigInteger;

/**
 * Project Euler, Problem 16:
 *
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 *
 * Created by : aboyer (12/21/12 20:45)
 */
public class Problem16 {
    public static void main(String[] args) {
        BigInteger num = BigInteger.valueOf(2);
        int power = 1000;
        BigInteger pow = num.pow(power);
        String str = pow.toString();
        char[] digits = str.toCharArray();
        long sum = 0;

        for (int i=0; i<digits.length; i++) {
            sum += (digits[i] - '0');
        }

//        System.out.printf("2^%d = %s\n",power,str);
        System.out.printf("Sum of the digits is %d\n",sum);
    }
}
