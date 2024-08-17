import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;


public class Bag<Item> implements Iterable<Item> {
    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        // same as push() in Stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    private void print() {
        for (Item i : this) {
            System.out.print(i + ", ");
        }
        System.out.print("size: " + size());
        System.out.println(" empty or not: " + isEmpty());
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() { throw new UnsupportedOperationException(); }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<Integer>();

        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.print();

        bag.add(4);
        bag.add(5);
        bag.print();
    }
}