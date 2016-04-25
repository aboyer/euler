package org.boyerfamily.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Project Euler, Problem 18:
 *
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

 3
 7 4
 2 4 6
 8 5 9 3

 That is, 3 + 7 + 4 + 9 = 23.

 Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file
 containing a triangle with one-hundred rows.

 NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem,
 as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over twenty billion
 years to check them all. There is an efficient algorithm to solve it. ;o)
 *
 * Created by : aboyer (12/21/12 20:45)
 */
public class Problem67 {
//    private static final int SIZE = 4;
//    private static int numbers[][] = {{3},{7,4},{2,4,6},{8,5,9,3}};

    private static final int SIZE = 100;
    private static int numbers[][] = new int[SIZE][SIZE];
//    private static int numbers[][] = {
//    {75},
//    {95, 64},
//    {17, 47, 82},
//    {18, 35, 87, 10},
//    {20, 4, 82, 47, 65},
//    {19, 1, 23, 75, 3, 34},
//    {88, 2, 77, 73, 7, 63, 67},
//    {99, 65, 4, 28, 6, 16, 70, 92},
//    {41, 41, 26, 56, 83, 40, 80, 70, 33},
//    {41, 48, 72, 33 ,47, 32, 37, 16, 94, 29},
//    {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
//    {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
//    {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29 ,48},
//    {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
//    {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}};

    private static int line[] = new int[SIZE];

    // Start from the next to bottom, each position will add the greater of the two numbers under it.
    // Then, move up, keeping the sum.  You'll end up with the largest.
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("problem67_triangle.txt"));

            for (int row=0; row<SIZE; row++) {
                    String strLine = br.readLine();
                    if (strLine == null)
                        throw new RuntimeException("unexpected eof");

                    String strNumbers[] = strLine.split(" ");
                    for (int col=0; col<strNumbers.length; col++) {
                        numbers[row][col] = Integer.parseInt(strNumbers[col]);
//                        System.out.print(numbers[row][col] + " ");
                    }
//                    System.out.println();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int sums[] = new int[SIZE];
        for (int col = 0; col < SIZE; col++) {
            sums[col] = numbers[SIZE-1][col];
            System.out.print(sums[col] + " ");
        }
        System.out.println();

        for (int row = SIZE-2; row >= 0; row--) {
            line = numbers[row];


            for (int col = 0; col <= row; col++) {
                int larger = sums[col];
                if (sums[col] < sums[col+1])
                    larger = sums[col+1];

                sums[col] = larger + line[col];
                System.out.print(sums[col] + " ");
            }
            System.out.println();
        }
    }
}
