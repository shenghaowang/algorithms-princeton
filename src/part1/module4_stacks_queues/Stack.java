import edu.princeton.cs.algs4.StdOut;


public class Stack<Item> {
    private Node first = null;
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

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
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

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        StdOut.println(stack.isEmpty());
        StdOut.println(stack.size());

        stack.push("soccer");
        stack.push("basketball");
        stack.push("swimming");

        stack.print();
        StdOut.println(stack.isEmpty());
        StdOut.println(stack.size());

        StdOut.println(stack.pop());
        StdOut.println(stack.pop());

        stack.push("tennis");
        stack.print();
        StdOut.println(stack.size());

        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.isEmpty());
        StdOut.println(stack.size());
    }
}