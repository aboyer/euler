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
    public static void main(String[] args) {
        int sum = 1; // Count the center first
        int prev_corner = 1; // Top right corner for each ring
        for (int sideSize = 3; sideSize <= 1001; sideSize += 2) {
            int firstCorner = prev_corner + sideSize - 1;
            int ringTotal = (4 * firstCorner) + (6 * (sideSize-1));
            sum += ringTotal;
            prev_corner = sideSize * sideSize;
        }
        System.out.println("Total is: " + sum);
    }

}
