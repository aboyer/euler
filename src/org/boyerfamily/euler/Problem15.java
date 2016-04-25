package org.boyerfamily.euler;

/**
 * Project Euler, Problem 15:
 * Starting in the top left corner of a 2×2 grid, and only being able to
 * move to the right and down, there are exactly 6 routes to the bottom right corner.
 *
 *  How many such routes are there through a 20×20 grid?
 *
 * Created by : aboyer (5/14/12 11:12 PM)
 */
public class Problem15 {
    private static final int GRID_SIZE = 21;
    private static final int MAX_INDEX = GRID_SIZE - 1;

    // Create a 20 by 20 grid, then populate it backwards.  At any point, the total
    // paths will be the sum of the node to the right, plus the sum of the node to
    // the bottom.
    private static long pathCounts[][] = new long[GRID_SIZE][GRID_SIZE];


    public static void main(String[] args) {
        // Seed our right side and bottom edge with 1s, and the bottom right with 0
        for (int i=0; i<GRID_SIZE; i++) {
            pathCounts[MAX_INDEX][i] = 1;
            pathCounts[i][MAX_INDEX] = 1;
        }
        pathCounts[MAX_INDEX][MAX_INDEX] = 0;

        for (int x = MAX_INDEX-1; x >= 0; x--) {
            for (int y = MAX_INDEX-1; y >= 0; y--) {
                pathCounts[x][y] = countDown(x,y) + countRight(x,y);
            }
        }

        System.out.println("The grid is:");
        for (int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
                System.out.print(pathCounts[x][y] + "\t");
            }
            System.out.println();
        }

        System.out.println("first cell is: " + Long.toString(pathCounts[0][0]));
    }

    private static long countRight(int x, int y){
        if (x >= MAX_INDEX)
            throw new RuntimeException("countRight with too large of a X");

        return pathCounts[x+1][y];
    }

    private static long countDown(int x, int y) {
        if (y >= MAX_INDEX)
            throw new RuntimeException("countDown with too large of a Y");

        return pathCounts[x][y+1];
    }
}
