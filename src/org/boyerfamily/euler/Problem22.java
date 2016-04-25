package org.boyerfamily.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.text.Collator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Project Euler, Problem 22:
 *
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this
 * value by its alphabetical position in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the
 * 938th name in the list. So, COLIN would obtain a score of 938  53 = 49714.
 *
 * What is the total of all the name scores in the file?
 *
 * Created by : aboyer (12/21/12 20:45)
 */
public class Problem22 {
    public static void main(String[] args) {
        String str = "Colin";
        TreeSet<String> names = new TreeSet<String>(Collator.getInstance());
//        names.add("bob");
//        names.add("Joe");
//        names.add("Clyde");
//        names.add("andrew");

        long nameSum = 0;
        long lineNum = 1;


        try {
            BufferedReader br = new BufferedReader(new FileReader("names.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                names.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (String name : names) {
            long val = lineNum++ * getStringVal(name);

            System.out.printf("%s: %d * %d = %d\n",name,lineNum-1,getStringVal(name),val);
            nameSum += val;
        }

        System.out.println("Total sum is " + nameSum);
//        System.out.printf("val of %s = %d\n",str,getStringVal(str));
    }

    static private int getStringVal(String str) {
        char chars[] = str.toLowerCase().toCharArray();
        int sum = 0;

        for (int i=0; i<chars.length; i++) {
            if (chars[i]<'a' || chars[i]>'z')
                throw new RuntimeException("Character out of range: " + chars[i] + " name: " + str);

            sum += chars[i]-'a'+1;
        }

        return sum;
    }
}
