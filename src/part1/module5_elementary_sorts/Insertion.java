/******************************************************************************
 *  Implement the insertion sort algorithm
 *
 *  Compilation:  javac-algs4 Insertion.java
 *  Execution:    java-algs4 Insertion 10
 *
 *  Dependencies: StdRandom.java, StdOut.java
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class Insertion {
    public static void sort(Double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--)
                if (less(a[j], a[j-1]))
                    exch(a, j, j-1);
                else break;
        }
    }

    private static boolean less(Double v, Double w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Double[] a, int i, int j) {
        Double swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(Double[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniformDouble();

        StdOut.println("Before sorting:");
        Insertion.show(a);
        StdOut.println();

        Insertion.sort(a);

        StdOut.println("After sorting:");
        Insertion.show(a);
    }
}