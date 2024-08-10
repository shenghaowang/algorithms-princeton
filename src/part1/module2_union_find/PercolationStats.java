import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {

    private static final double CONFIDENCE_95 = 1.96;
    private int numTrials;
    private double[] results;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0)
            throw new IllegalArgumentException(
                String.format("Non-positive size of grid %s is given.", n)
            );

        if (trials <= 0)
            throw new IllegalArgumentException(
                String.format("Non-positive number of trials %s is given.", trials)
            );

        numTrials = trials;
        results = new double[trials];
        for (int i=0; i < trials; i++) {
            Percolation grid = new Percolation(n);

            while (!grid.percolates()) {
                // open a random site
                int row = StdRandom.uniformInt(n) + 1;
                int col = StdRandom.uniformInt(n) + 1;

                if (!grid.isOpen(row, col))
                    grid.open(row, col);
            }

            results[i] = grid.numberOfOpenSites() * 1.0 / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - CONFIDENCE_95 * stddev() / Math.sqrt(numTrials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + CONFIDENCE_95 * stddev() / Math.sqrt(numTrials);
    }

    // test client (see below)
    public static void main(String[] args) {
        if (args.length < 2)
            throw new IllegalArgumentException("Missing grid size and number of trials arguments");

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(n, trials);

        String confidence = "[" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]";
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }

}