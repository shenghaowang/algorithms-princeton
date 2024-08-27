/******************************************************************************
 *  Compilation:  javac-introcs ShannonEntropy.java
 *  Execution:    java-introcs ShannonEntropy
 *  Dependencies: StdIn.java, StdOut.java
 *
 *  Implementation of a 2-d bouncing ball in the box from (-1, -1) to (1, 1).
 *
 *
 ******************************************************************************/

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] freq = new int[m];

        int count = 0;
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            freq[x-1]++;
            count++;
        }

        double sum = 0.0;
        for (int i = 0; i < freq.length; i++) {
            double p = freq[i] * 1.0 / count;
            if (p > 0)
                sum -= p * Math.log(p) / Math.log(2.0);
        }

        StdOut.println(String.format("%.4f", sum));
    }
}