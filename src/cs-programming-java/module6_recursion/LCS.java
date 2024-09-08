/******************************************************************************
 *  Compute the length of the Longest common subsequence (LCS)
 *  of two strings.
 *
 *  Compilation:  javac-introcs LCS.java
 *  Execution:    java-introcs LCS ggcaccacg acggcggatacg
 *
 ******************************************************************************/

public class LCS {
    public static void main(String[] args) {
        String s = args[0];
        String t = args[1];
        int M = s.length();
        int N = t.length();

        // keep track of the length of the LCS of the tails
        // of two strings s[i...M) and t[j...N) in opt[i, j].
        int[][] opt = new int[M+1][N+1];

        for (int i = M-1; i >= 0; i--)
            for (int j = N-1; j >= 0; j--)
                if (s.charAt(i) == t.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
        System.out.println(opt[0][0]);
    }
}