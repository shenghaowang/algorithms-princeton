/******************************************************************************
 *  Generate a permutation of length n with exactly k inversions.
 *
 *  Compilation:  javac-introcs Inversions.java
 *  Execution:    java-introcs Inversions 10 0
 *  Execution:    java-introcs Inversions 10 1
 *  Execution:    java-introcs Inversions 10 45
 *  Execution:    java-introcs Inversions 10 20
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long numInversions = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    numInversions++;
                }
            }
        }

        return numInversions;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        int first = 0, last = n-1;

        while (n > 0) {
            if (k >= n-1) {
                a[first] = n - 1;
                first++;
                k -= n-1;
            } else {
                a[last] = n - 1;
                last--;
            }
            n--;

            // StdOut.println("k: " + k + " n: " + n);
            // for (int i : a) {
            //     StdOut.print(i + " ");
            // }
            // StdOut.println();
        }

        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        for (int i : generate(n, k)) {
            StdOut.print(i + " ");
        }
    }
}