/******************************************************************************
 *  Implement the selection sort algorithm
 *
 *  Compilation:  javac-algs4 Selection.java
 *  Execution:    java-algs4 Selection 10
 *
 *  Dependencies: StdRandom.java, StdOut.java
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class Selection {
    public static void sort(Double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i; // index of the minimum element
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;
            exch(a, i, min);
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
        Selection.show(a);
        StdOut.println();

        Selection.sort(a);

        StdOut.println("After sorting:");
        Selection.show(a);
    }
}