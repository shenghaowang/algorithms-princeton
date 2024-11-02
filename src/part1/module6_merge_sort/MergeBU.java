/******************************************************************************
 *  Bottom-up implementation of mergesort.
 *
 *  Compilation:  javac-algs4 MergeBU.java
 *  Execution:    java-algs4 MergeBU < tiny.txt
 *  Execution:    java-algs4 MergeBU < words3.txt
 *
 *  Dependencies: StdRandom.java, StdOut.java
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeBU {
    private static String[] aux;

    private static void merge(String[] a, int lo, int mid, int hi){
        assert isSorted(a, lo, mid);    // precondition: a[lo..mid]   sorted
        assert isSorted(a, mid+1, hi);  // precondition: a[mid+1..hi] sorted

        // copy to aux[]
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                    a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }

        // postcondition: a[lo .. hi] is sorted
        assert isSorted(a, lo, hi);
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        for (int sz = 1; sz < N; sz = sz + sz)
            for (int lo = 0; lo < N - sz; lo += sz + sz)
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
    }

    private static boolean less(String v, String w) {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(String[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static void show(String[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        StdOut.println("Before sorting:");
        MergeBU.show(a);
        StdOut.println();

        MergeBU.sort(a);

        StdOut.println("After sorting:");
        show(a);
    }
}