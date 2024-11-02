/******************************************************************************
 *  Implement the merge sort algorithm
 *
 *  Compilation:  javac-algs4 Merge.java
 *  Execution:    java-algs4 Merge < tiny.txt
 *  Execution:    java-algs4 Merge < word3.txt
 *
 *  Dependencies: StdRandom.java, StdOut.java
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class Merge {

    private static void merge(String[] a, String[] aux, int lo, int mid, int hi){
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

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(String[] a, String[] aux, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(String[] a) {
        String[] aux = new String[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/

    // is v < w ?
    private static boolean less(String v, String w) {
        return v.compareTo(w) < 0;
    }

    /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/

    private static boolean isSorted(String[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private static void show(String[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        StdOut.println("Before sorting:");
        Merge.show(a);
        StdOut.println();

        Merge.sort(a);

        StdOut.println("After sorting:");
        show(a);
    }
}