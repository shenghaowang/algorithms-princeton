import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> que = new RandomizedQueue<>();
        int k = Integer.parseInt(args[0]);

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            que.enqueue(word);
        }

        for (int i = 0; i < k; i++) {
            StdOut.println(que.dequeue());
        }
    }
 }