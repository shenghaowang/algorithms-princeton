import edu.princeton.cs.algs4.StdOut;


public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        return s[--N];
    }

    private void print() {
        for (int i = 0; i < N; i++) {
            StdOut.print(s[i] + " ");
        }

        StdOut.print("N = " + N);
        StdOut.println();
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(5);

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
        stack.print();

        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.isEmpty());
    }
}