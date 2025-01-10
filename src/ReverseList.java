import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {
    private static LinkedList<String> list = new LinkedList<>();

    public static void main(String[] args) {
        list.add("Adam");
        list.add("Bob");
        list.add("Charlie");
        list.add("Dave");
        System.out.println("Forward:");
        for (String s : list)
            System.out.println(s);

        LinkedList<String> reversed = new LinkedList<>();

        reverseList(list.iterator(), reversed);

        System.out.println("Reversed:");
        for (String s : reversed)
            System.out.println(s);
    }

    private static void reverseList(Iterator<String> iter, LinkedList<String> reversed) {
        if (iter.hasNext()) {
            reversed.push(iter.next());
            reverseList(iter, reversed);
        }
    }
}
