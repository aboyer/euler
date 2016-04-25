package org.boyerfamily.euler;

/**
 * Project Euler, Problem 14:
 *   The following iterative sequence is defined for the set of positive integers:

 n  n/2 (n is even)
 n  3n + 1 (n is odd)

 Using the rule above and starting with 13, we generate the following sequence:

 13  40  20  10  5  16  8  4  2  1
 It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

 Which starting number, under one million, produces the longest chain?

 NOTE: Once the chain starts the terms are allowed to go above one million.

 * Created by : aboyer (5/14/12 11:11 PM)
 */
public class Problem14 {
    public static void main(String[] args) {
        int max_num = 0;
        int max_length = 0;

        for (int i=1; i<1000000; i++) {
            int length = chainLength(i);

            if (length > max_length) {
                max_num = i;
                max_length = length;
            }
        }

        System.out.printf("%d has the longest chain (%d).\n",max_num,max_length);
    }

    private static int chainLength(int i) {
        int count = 1;
        long term = i;

        while (term != 1) {
//            System.out.printf("%d, ",term);
            term = next(term);
            count++;
        }

//        System.out.printf("1 (%d)\n",count);

        return count;
    }

    private static long next(long l) {
        if (l % 2 == 0) {
            return l/2;
        }

        return 3*l+1;
    }
}
