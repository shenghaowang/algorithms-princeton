/******************************************************************************
 *  Compute trinomial coefficient
 *
 *  Compilation:  javac-introcs TrinomialBrute.java
 *  Execution:    java-introcs TrinomialBrute 3 3
 *  Execution:    java-introcs TrinomialBrute 3 2
 *  Execution:    java-introcs TrinomialBrute 3 1
 *  Execution:    java-introcs TrinomialBrute 3 0
 *  Execution:    java-introcs TrinomialBrute 24 12
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class TrinomialBrute {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0)
            return 1;

        else if (k < -n || k > n)
            return 0;

        else
            return trinomial(n-1, k-1) + trinomial(n-1, k) + trinomial(n-1, k+1);
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdOut.println(trinomial(n, k));
    }
}