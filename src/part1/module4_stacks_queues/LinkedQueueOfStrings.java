import edu.princeton.cs.algs4.StdOut;


public class LinkedQueueOfStrings {
    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // add item to the end of queue
    public void enqueue(String item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
    }

    // remove item from the start of queue
    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }

        return item;
    }

    private void print() {
        Node current = first;
        while (current != null) {
            StdOut.print(current.item + ' ');
            current = current.next;
        }

        StdOut.println();
    }

    public static void main(String[] args) {
        LinkedQueueOfStrings queue = new LinkedQueueOfStrings();

        StdOut.println(queue.isEmpty());

        queue.enqueue("apple");
        queue.enqueue("burger");
        queue.enqueue("carrot");

        queue.print();
        StdOut.println(queue.isEmpty());

        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());

        queue.enqueue("donut");
        queue.print();

        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.isEmpty());
    }
}