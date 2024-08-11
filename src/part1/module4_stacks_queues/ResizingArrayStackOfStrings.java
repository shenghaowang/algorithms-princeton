import edu.princeton.cs.algs4.StdOut;


public class ResizingArrayStackOfStrings {
    private String[] s;
    private int N = 0;

    public ResizingArrayStackOfStrings() {
        s = new String[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int getSize() {
        return s.length;
    }

    public void push(String item) {
        if (N == s.length) {
            resize(2 * s.length);
        }

        s[N++] = item;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }

        return item;
    }

    public void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }

        s = copy;
    }

    private void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(s[i] + " ");
        }

        StdOut.print(" -> Length of stack = " + getSize());
        StdOut.println();
    }

    public static void main(String[] args) {
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();

        StdOut.println(stack.isEmpty());

        stack.push("apple");
        stack.push("burger");
        stack.push("carrot");

        stack.print();
        StdOut.println(stack.isEmpty());

        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        stack.print();

        stack.push("donut");
        stack.push("eggplant");
        stack.print();

        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.getSize());

        StdOut.println(stack.pop());
        StdOut.println(stack.isEmpty());
    }
}