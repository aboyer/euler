package org.boyerfamily.euler;

public class GetAllPermutations {
    private static int count = 0;
    private static final int LIMIT = 1000;

    public static void getPermutations(int[] array){
        helper(array, 0);
    }

    private static void helper(int[] array, int pos){
        if(pos == array.length) {
            count++;
//            if (count == LIMIT) {
                System.out.print(count + ": [");
                for (int i = 0; i < array.length - 1; i++) {
                    System.out.print(array[i] + ", ");
                }
                if (array.length > 0)
                    System.out.print(array[array.length - 1]);
                System.out.println("]");
//            }
            return;
        }

        for(int i = pos; i < array.length; i++){
            System.out.println("swapping " + pos + " and " + i);

            int t = array[pos];
            array[pos] = array[i];
            array[i] = t;

            helper(array, pos+1);

            t = array[pos];
            array[pos] = array[i];
            array[i] = t;
        }
    }
    public static void main(String args[]) {
        int[] numbers = {0, 1, 2, 3};
//        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        getPermutations(numbers);
    }
}