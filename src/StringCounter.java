import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * TODO: File Purpose
 * <p/>
 * Created by : aboyer (5/29/14 05:41)
 */
public class StringCounter {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: StringCounter {string}" + args[0]);
            System.exit(1);
        }

        getMostFrequentChar(args[0]);

    }

    static int getMostFrequentChar(String str) {
        System.out.println("Input: " + str);

        char strChars[] = str.toCharArray();
        Map<Character,Integer> counts = new TreeMap<>();

        int highCount = 0;
        Character highChar = null;

        for (int x=0; x<strChars.length; x++) {
            char character = strChars[x];

            if (counts.containsKey(character)) {
                counts.put(character,counts.get(character)+1);
            }  else {
                counts.put(character,1);
            }

            if (counts.get(character) > highCount) {
                highChar = character;
                highCount = counts.get(character);
            }
        }

        System.out.println("char: " + highChar);
        System.out.println("count: " + highCount);
        System.out.println(counts);

        return highCount;
    }
}
