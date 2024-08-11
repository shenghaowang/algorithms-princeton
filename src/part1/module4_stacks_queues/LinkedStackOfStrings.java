import edu.princeton.cs.algs4.StdOut;


public class LinkedStackOfStrings {
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
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
        LinkedStackOfStrings stack = new LinkedStackOfStrings();

        StdOut.println(stack.isEmpty());

        stack.push("apple");
        stack.push("burger");
        stack.push("carrot");

        stack.print();
        StdOut.println(stack.isEmpty());

        StdOut.println(stack.pop());
        StdOut.println(stack.pop());

        stack.push("donut");
        stack.print();

        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.isEmpty());
    }
}