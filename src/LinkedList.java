/**
 * TODO: File Purpose
 * <p/>
 * Created by : aboyer (5/30/14 09:46)
 */
public class LinkedList {
    static int index=0;

    class Node {

        public int value;
        public Node next = null;
        public Node prev = null;

        Node() {
            this.value = index++;
        }

        Node(Node prev, Node next) {
            this.value = index++;
            this.prev = prev;
            this.next = next;
        }
    }

    class NodeList {
        public Node first;
        public Node last;

        NodeList() {
            first = new Node();
            last = first;
        }

        public void appendNode() {
            Node node = new Node(last, null);
            last.next = node;
            last = node;
        }

        public void printList() {
            System.out.print(first.value + " ");
            Node node = first;

            while (node.next != null) {
                node = node.next;
                System.out.print(node.value + " ");
            }

            System.out.println("");
        }
    }

    public static void main(String[] args) {
        NodeList list = null; // new NodeList();

        for (int i = 0; i<5; i++) {
            list.appendNode();
        }

        list.printList();
    }
}
