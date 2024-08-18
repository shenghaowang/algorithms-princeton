import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;


public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int n;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {
        n = 0;
        first = last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item can't be null");
        }

        Node current = new Node();
        current.item = item;

        if (n == 0) {
            first = last = current;
        } else {
            first.prev = current;
            current.next = first;
            first = current;
        }

        n++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item can't be null");
        }

        Node current = new Node();
        current.item = item;

        if (n == 0) {
            first = last = current;
        } else {
            last.next = current;
            current.prev = last;
            last = current;
        }

        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (n == 0) {
           throw new NoSuchElementException("Deque is empty.");
        }

        Item item = first.item;
        first = first.next; // next element could be null

        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }

        n--;

        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (n == 0) {
            throw new NoSuchElementException("Deque is empty.");
        }

        Item item = last.item;
        last = last.prev;   // previous element could be null
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }

        n--;

        return item;
    }

    private void print() {
        Node current = first;
        while (current != null) {
            StdOut.print(current.item + " ");
            current = current.next;
        }

        StdOut.println();
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DeqIterator();
    }

    private class DeqIterator implements Iterator<Item> {
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

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> que = new Deque<>();
        que.addFirst(1);
        que.print();
        que.removeFirst();
        que.print();

        que.addLast(2);
        que.print();
        que.removeLast();
        que.print();

        que.addFirst(3);
        que.print();
        que.removeLast();
        que.print();

        que.addLast(4);
        que.print();
        que.removeFirst();
        que.print();


        StdOut.println("size: " + que.size());
        StdOut.println(que.isEmpty());
        que.addFirst(2);
        que.addFirst(3);
        que.addFirst(4);
        que.addFirst(5);
        que.addLast(6);
        que.addLast(7);
        que.addLast(8);
        que.addLast(9);
        que.addLast(10);
        que.addFirst(0);
        que.print();
        StdOut.println("size: " + que.size());

        StdOut.println(que.removeFirst());
        StdOut.println(que.removeFirst());
        StdOut.println(que.removeFirst());
        que.print();
        StdOut.println("size: " + que.size());

        StdOut.println(que.removeLast());
        StdOut.println(que.removeLast());
        StdOut.println(que.removeLast());
        que.print();
        StdOut.println("size: " + que.size());
    }

}