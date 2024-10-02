/******************************************************************************
 *  Compute trinomial coefficient with dynamic programming
 *
 *  Compilation:  javac-introcs TrinomialDP.java
 *  Execution:    java-introcs TrinomialDP 3 0
 *  Execution:    java-introcs TrinomialDP 24 12
 *  Execution:    java-introcs TrinomialDP 30 0
 *  Execution:    java-introcs TrinomialDP 40 0
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        long[][] res = new long[n+1][n+1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= i; j++)
                if (i == j)
                    res[i][j] = 1;
                else if (i > 0 && j == 0)
                    res[i][j] = res[i-1][j] + 2 * res[i-1][j+1];
                else
                    res[i][j] = res[i-1][j-1] + res[i-1][j] + res[i-1][j+1];

        if (k < -n || k > n) return 0;
        else if (k < 0) return res[n][-k];
        else return res[n][k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdOut.println(trinomial(n, k));
    }
}