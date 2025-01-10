package org.boyerfamily.euler.utils;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;

/**
 * This is a collection of utility methods having to do with prime numbers.
 *
 * Created by : aboyer (5/1/12 4:40 PM)
 */
public class Prime {
    private static HashSet<Integer> primes = new HashSet<>();

    public static void loadPrimes() {
        try {
            FileInputStream fis = new FileInputStream("primes.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            primes = (HashSet<Integer>) ois.readObject();
            ois.close();
            fis.close();
        } catch (ClassNotFoundException|IOException e) {
            e.printStackTrace();
        }
    }

    public static void writePrimes(int upperBound) {
        boolean[] nums = new boolean[upperBound +1];
        Arrays.fill(nums, true);

        for (int p = 2; p * p <= upperBound; p++) {
            if (nums[p]) {
                for (int i = p * 2; i <= upperBound; i += p) {
                    nums[i] = false;
                }
            }
        }

        for (int i = 2; i <= upperBound; i++) {
            if (nums[i]) {
                primes.add(i);
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream("primes.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(primes);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isPrime(long candidate) {
        if (candidate == 2) {
            return true;
        }

        if (candidate < 2 || candidate % 2 == 0) // The only even prime is 2
            return false;


        long limit = round(sqrt(candidate));
        for (long l = 3; l<= limit; l+=2) {
            if (candidate%l == 0)
                return false;
        }

        return true;
    }
}
