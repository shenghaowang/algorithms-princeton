import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class RandomWord {

    public static void main(String[] args) {

        int count = 1;
        String champion = "";

        while (!StdIn.isEmpty()) {

            String word = StdIn.readString();

            if (StdRandom.bernoulli(1.0 / count)) {
                champion = word;
            }

            count += 1;
        }

        // print the champion word
        StdOut.println(champion);

    }
}