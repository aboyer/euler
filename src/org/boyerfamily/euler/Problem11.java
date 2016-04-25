package org.boyerfamily.euler;

/**
 * Project Euler, Problem Eleven:
 *   In the 2020 grid below, four numbers along a diagonal line have been marked in red.

 08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
 52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
 32 98 81 28 64 23 67 10 26* 38 40 67 59 54 70 66 18 38 64 70
 67 26 20 68 02 62 12 20 95 63* 94 39 63 08 40 91 66 49 94 21
 24 55 58 05 66 73 99 26 97 17 78* 78 96 83 14 88 34 89 63 72
 21 36 23 09 75 00 76 44 20 45 35 14* 00 61 33 97 34 31 33 95
 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
 19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
 04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
 88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
 01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48

 The product of these numbers is 26  63  78  14 = 1788696.

 What is the greatest product of four adjacent numbers in any direction (up, down, left, right, or diagonally) in the 2020 grid?
 * Created by : aboyer (5/7/12 12:20 AM)
 */
public class Problem11 {
    public static final int DIGIT_COUNT = 4;
    public static final int SIZE=20;
    public static final long[][] NUMBERS = {
        { 8,  2, 22, 97, 38, 15,  0, 40,  0, 75,  4,  5,  7, 78, 52, 12, 50, 77, 91,  8},
        {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48,  4, 56, 62,  0},
        {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30,  3, 49, 13, 36, 65},
        {52, 70, 95, 23,  4, 60, 11, 42, 69, 24, 68, 56,  1, 32, 56, 71, 37,  2, 36, 91},
        {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
        {24, 47, 32, 60, 99,  3, 45,  2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
        {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
        {67, 26, 20, 68,  2, 62, 12, 20, 95, 63, 94, 39, 63,  8, 40, 91, 66, 49, 94, 21},
        {24, 55, 58,  5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
        {21, 36, 23,  9, 75,  0, 76, 44, 20, 45, 35, 14,  0, 61, 33, 97, 34, 31, 33, 95},
        {78, 17, 53, 28, 22, 75, 31, 67, 15, 94,  3, 80,  4, 62, 16, 14,  9, 53, 56, 92},
        {16, 39,  5, 42, 96, 35, 31, 47, 55, 58, 88, 24,  0, 17, 54, 24, 36, 29, 85, 57},
        {86, 56,  0, 48, 35, 71, 89,  7,  5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
        {19, 80, 81, 68,  5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77,  4, 89, 55, 40},
        { 4, 52,  8, 83, 97, 35, 99, 16,  7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
        {88, 36, 68, 87, 57, 62, 20, 72,  3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
        { 4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18,  8, 46, 29, 32, 40, 62, 76, 36},
        {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74,  4, 36, 16},
        {20, 73, 35, 29, 78, 31, 90,  1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57,  5, 54},
        { 1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52,  1, 89, 19, 67, 48}};


    public static void main(String[] args) {
        long maxVertical = getVerticalMax();
        long maxHorizontal = getHorizontalMax();
        long maxLeftDiagonal = getLeftDiagonalMax();
        long maxRightDiagonal = getRightDiagonalMax();
        long max = Math.max(Math.max(maxVertical,maxHorizontal),Math.max(maxLeftDiagonal,maxRightDiagonal));

        System.out.printf("Overall max is %d\n",max);
    }

    static long getVerticalMax() {
        long max=productDownAt(0, 0);
        int maxStartX=0;
        int maxStartY=0;
        long product=max;
        int count=0;

        for (int col=0; col<SIZE; col++) {
            for (int row=0; row<SIZE-DIGIT_COUNT; row++) {
                count++;
                if (row>0 && NUMBERS[col][row-1] > 0)
                    product = product / NUMBERS[col][row-1] * NUMBERS[col][row+DIGIT_COUNT-1];
                else
                    product = productDownAt(col,row);

                if (product<0)
                    throw new RuntimeException("# too big");

                if (product > max) {
                    max = product;
                    maxStartX = col;
                    maxStartY = row;
                }
            }
        }

        System.out.printf("Vertical max %d, starting at (%d,%d), numbers (%s), count %d\n",
                max,maxStartX,maxStartY,stringDownAt(maxStartX,maxStartY),count);

        return max;
    }


    static long getHorizontalMax() {
        long max=productRightAt(0,0);
        int maxStartX=0;
        int maxStartY=0;
        long product=max;
        int count =0;

        for (int row=0; row<SIZE; row++) {
            for (int col=0; col<SIZE-DIGIT_COUNT; col++) {
                count++;
                if (col>0 && NUMBERS[col-1][row] > 0)
                    product = product / NUMBERS[col-1][row] * NUMBERS[col+DIGIT_COUNT-1][row];
                else
                    product = productRightAt(col,row);

                if (product<0)
                    throw new RuntimeException("# too big");

                if (product > max) {
                    max = product;
                    maxStartX = col;
                    maxStartY = row;
                }
            }
        }

        System.out.printf("Horizontal max %d, starting at (%d,%d), numbers (%s), count %d\n",
                max,maxStartX,maxStartY,stringRightAt(maxStartX,maxStartY),count);

        return max;
    }

    static long getLeftDiagonalMax() {
        long max=productLeftDiagonalAt(0, 0);
        int maxStartX=0;
        int maxStartY=0;
        long product=max;
        int count=0;

        for (int row=0; row<=SIZE-DIGIT_COUNT; row++) {
            for (int col=0; col<=SIZE-DIGIT_COUNT; col++) {
                count++;
//                if (row>0 && col>0 && NUMBERS[col-1][row-1] > 0) {
//                    product = product / NUMBERS[col-1][row-1] * NUMBERS[col+DIGIT_COUNT-1][row+DIGIT_COUNT-1];
//                } else
                    product = productLeftDiagonalAt(col, row);

                if (product<0)
                    throw new RuntimeException("# too big");

                if (product > max) {
                    max = product;
                    maxStartX = col;
                    maxStartY = row;
                }
            }
        }

        System.out.printf("Left diagonal max %d, starting at (%d,%d), numbers (%s), count %d\n",
                max,maxStartX,maxStartY,stringLeftDiagonalAt(maxStartX, maxStartY),count);

        return max;
    }

    static long getRightDiagonalMax() {
        long max=productRightDiagonalAt(DIGIT_COUNT - 1, 0);
        int maxStartX=DIGIT_COUNT-1;
        int maxStartY=0;
        long product=max;
        int count=0;

        for (int row=0; row<=SIZE-DIGIT_COUNT; row++) {
            for (int col=DIGIT_COUNT-1; col<SIZE; col++) {
                count++;
//                System.out.printf("Processing (%d,%d)...\n",col,row);
//                if (row>0 && col<SIZE-1 && NUMBERS[col+1][row-1] > 0) {
//                    product = product / NUMBERS[col+1][row-1] * NUMBERS[col-(DIGIT_COUNT-1)][row+DIGIT_COUNT-1];
//                } else
                    product = productRightDiagonalAt(col,row);

                if (product<0)
                    throw new RuntimeException("# too big");

                if (product > max) {
                    max = product;
                    maxStartX = col;
                    maxStartY = row;
                }
            }
        }

        System.out.printf("Right diagonal max %d, starting at (%d,%d), numbers (%s), count %d\n",
                max,maxStartX,maxStartY,stringRightDiagonalAt(maxStartX, maxStartY),count);

        return max;
    }

    static long productDownAt(int x, int y) {
        if (y>=SIZE-DIGIT_COUNT)
            throw new IllegalArgumentException("Running off edge of matrix x="+x);

        long product = 1;

        for (int i=0; i<DIGIT_COUNT; i++)
            product *= NUMBERS[x][y+i];

        return product;
    }

    static long productRightAt(int x, int y) {
        if (x>=SIZE-DIGIT_COUNT)
            throw new IllegalArgumentException("Running off edge of matrix");

        long product = 1;

        for (int i=0; i<DIGIT_COUNT; i++)
            product *= NUMBERS[x+i][y];

        return product;
    }

    static long productLeftDiagonalAt(int x, int y) {
        if (x>SIZE-DIGIT_COUNT || y> SIZE-DIGIT_COUNT)
            throw new IllegalArgumentException("Running off edge of matrix");

        long product = 1;

        for (int i=0; i<DIGIT_COUNT; i++)
            product *= NUMBERS[x+i][y+i];

        return product;
    }

    static long productRightDiagonalAt(int x, int y) {
        if (x<DIGIT_COUNT-1 || y>SIZE-DIGIT_COUNT)
            throw new IllegalArgumentException("Running off edge of matrix");

        long product = 1;

        for (int i=0; i<DIGIT_COUNT; i++)
            product *= NUMBERS[x-i][y+i];

        return product;
    }

    static String stringDownAt(int x, int y) {
        StringBuffer strbuf = new StringBuffer();

        for (int i=0; i<DIGIT_COUNT; i++)
            strbuf.append(Long.toString(NUMBERS[x][y+i])+" ");

        return strbuf.deleteCharAt(strbuf.length()-1).toString();
    }

    static String stringRightAt(int x, int y) {
        StringBuffer strbuf = new StringBuffer();

        for (int i=0; i<DIGIT_COUNT; i++)
            strbuf.append(Long.toString(NUMBERS[x+i][y])+" ");

        return strbuf.deleteCharAt(strbuf.length()-1).toString();
    }

    static String stringLeftDiagonalAt(int x, int y) {
        StringBuffer strbuf = new StringBuffer();

        for (int i=0; i<DIGIT_COUNT; i++)
            strbuf.append(Long.toString(NUMBERS[x+i][y+i])+" ");

        return strbuf.deleteCharAt(strbuf.length()-1).toString();
    }

    static String stringRightDiagonalAt(int x, int y) {
        StringBuffer strbuf = new StringBuffer();

        for (int i=0; i<DIGIT_COUNT; i++)
            strbuf.append(Long.toString(NUMBERS[x-i][y+i])+" ");

        return strbuf.deleteCharAt(strbuf.length()-1).toString();
    }
}
