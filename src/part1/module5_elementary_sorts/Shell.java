/******************************************************************************
 *  Implement the shell sort algorithm
 *
 *  Compilation:  javac-algs4 Shell.java
 *  Execution:    java-algs4 Shell 10
 *
 *  Dependencies: StdRandom.java, StdOut.java
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;

        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, ...

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++)
                for (int j = i; j >= h && less(a[j], a[j-h]); j-=h)
                    exch(a, j, j-h);

            h = h/3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];

        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();

        StdOut.println("Before sorting:");
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);

        Selection.sort(a);

        StdOut.println("After sorting:");
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
    }
}