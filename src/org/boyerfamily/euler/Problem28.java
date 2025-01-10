package org.boyerfamily.euler;

import org.testng.Assert;

/**
 * Problem 28:
 *
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

 21* 22 23 24 25*
 20  7*  8  9* 10
 19  6  1*  2 11
 18  5*  4  3* 12
 17* 16 15 14 13*

 It can be verified that the sum of the numbers on the diagonals is 101.

 What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?

 Analysis:
 - walk the matrix, without creating it.  Loop from 1 to n, where n is the count of all cells.
 - keep a running sum of cells that are diagonals (need a boolean isDiagonal)
 - need a function getNext that will implement the spiral, and return x,y coordinates
 - maybe a point helper class
 - n ~ 1M, so the sums should fit in a long

 Second analysis:
 The top right diagonal appears to be squares of the side (1,3,5,7) -> (1, 9, 25, 49)
 * Created by : aboyer (5/9/14 14:00)
 */
public class Problem28 {
    public static final int SIZE = 5;
    public static final int TOTAL_SIZE = SIZE * SIZE;
    public static final int MIDDLE = SIZE / 2;
    public static final int MAX_INDEX = SIZE - 1;

    public static void main(String[] args) {
        if (SIZE%2 == 1) {
            throw new RuntimeException("this assumes size is odd, size is: " + SIZE);
        }

        int sum = 1; // Count the center first
        for (int sideSize = 3; sideSize <= 1001; sideSize += 2) {
            int topRight = sideSize * sideSize;
            int topLeft = topRight - (sideSize-1);
            int lowerLeft = topLeft - (sideSize-1);
            int lowerRight = lowerLeft - (sideSize-1);
            System.out.printf("sum=%d, topRight=%d, topLeft=%d, lowerLeft=%d, lowerRight=%d\n", sum, topRight, topLeft, lowerLeft, lowerRight);
            sum += topRight + topLeft + lowerLeft + lowerRight;
        }
        System.out.println("Total is: " + sum);
    }

}
