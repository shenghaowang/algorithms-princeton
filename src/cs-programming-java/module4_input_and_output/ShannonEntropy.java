/******************************************************************************
 *  Compilation:  javac-introcs ShannonEntropy.java
 *  Execution:    java-introcs ShannonEntropy 2 < fair-coin.txt
 *  Execution:    java-introcs ShannonEntropy 6 < loaded-die.txt
 *
 *  Dependencies: StdIn.java, StdOut.java
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