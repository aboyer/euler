package org.boyerfamily.euler;

/**
 * Project Euler, Problem 9:
 *  A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,
 *  a^2 + b^2 = c^2
 *
 *  For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 *  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 *
 *  Find the product abc.
 *
 * Created by : aboyer (5/1/12 11:38 PM)
 */
public class Problem9 {
    public static final int LIMIT=10;

    public static void main(String[] args) {
        for (int a=333; a>0; a--) {
            int aa = a*a;

            for (int b=a+1; 2*b+a<=1000; b++) {
                int c = 1000-b-a;
                if (aa+(b*b)==c*c)
                    System.out.printf("Found triplet (%d,%d,%d), product is %d\n",a,b,c,a*b*c);
            }
        }
    }
}
