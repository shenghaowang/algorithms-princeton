import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a;
    private int n;

    // construct an empty randomized queue
    public RandomizedQueue() {
        a = (Item[]) new Object[1];
        n = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    private void resize(int max) {
        // Move queue to a new array of size max
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++)
            tmp[i] = a[i];

        a = tmp;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item can't be null");
        }

        if (n == a.length) {
            resize(2 * a.length);
        }

        a[n++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (n == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }

        int randomIndex = StdRandom.uniformInt(n);
        Item randomItem = a[randomIndex];

        // fill in the random index with the last element
        a[randomIndex] = a[--n];
        a[n] = null;

        return randomItem;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (n == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }

        return a[StdRandom.uniformInt(n)];
    }

    private void print() {
        for (Item i : this) {
            StdOut.print(i + ", ");
        }

        StdOut.println();
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ShuffleArrayIterator();
    }

    private class ShuffleArrayIterator implements Iterator<Item> {
        private int current = 0;
        private Item[] arr;

        public ShuffleArrayIterator() {
            arr = (Item[]) new Object[n];
            for (int i = 0; i < n; i++)
                arr[i] = a[i];

            StdRandom.shuffle(arr);
        }

        @Override
        public boolean hasNext() {
            return current < arr.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("there are no more items");
            }

            return arr[current++];
        }

        @Override
        public void remove() { throw new UnsupportedOperationException(); }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> que = new RandomizedQueue<>();
        StdOut.println("size: " + que.size());
        StdOut.println("empty: " + que.isEmpty());
        que.print();

        que.enqueue(1);
        StdOut.println("size: " + que.size());
        StdOut.println("empty: " + que.isEmpty());
        que.print();

        que.enqueue(2);
        que.enqueue(3);
        que.enqueue(4);
        que.enqueue(5);
        que.enqueue(6);
        que.print();
        que.print();
        que.print();
        que.print();
        StdOut.println(que.dequeue());
        StdOut.println(que.dequeue());
        StdOut.println(que.dequeue());
        StdOut.println(que.dequeue());
        StdOut.println("size: " + que.size());
        StdOut.println("empty: " + que.isEmpty());
        que.print();
        StdOut.println(que.sample());
        StdOut.println(que.sample());
        StdOut.println(que.sample());
        StdOut.println(que.sample());
        StdOut.println(que.dequeue());
        StdOut.println(que.dequeue());
        StdOut.println("size: " + que.size());
        StdOut.println("empty: " + que.isEmpty());
    }

}