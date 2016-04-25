package org.boyerfamily.euler;

import sun.jvm.hotspot.utilities.Assert;
import static java.lang.Math.abs;

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

 * Created by : aboyer (5/9/14 14:00)
 */
public class Problem28 {
    public static final int SIZE = 5;
    public static final int TOTAL_SIZE = SIZE * SIZE;
    public static final int MIDDLE = SIZE / 2;
    public static final int MAX_INDEX = SIZE - 1;

    public static void main(String[] args) {
        Assert.that(SIZE%2 == 1,"this assumes size is odd");


//        Poin

    }

//    class Point {
//        int x, y;
//
//        Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        };
//
//        public boolean isDiagonal() {
//            // Figure out the absolute value from the center point, both x and y.
//            // If those are equal, it's a diagonal
//            if ((abs(x - MIDDLE)) == (abs(y - MIDDLE))) {
//                return true;
//            }
//
//            return false;
//        };
//
//        public Point nextPoint() {
//
//        };
//    }
}
