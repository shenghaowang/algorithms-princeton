import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    // declare site status
    private final boolean BLOCKED = false;
    private final boolean OPEN = true;

    // declare variables
    private int size;
    private boolean[] grid;
    private WeightedQuickUnionUF percUnionFind;
    private WeightedQuickUnionUF fullUnionFind;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {

        if (n <= 0)
            throw new IllegalArgumentException("Invalid grid size: " + n);

        size = n;

        // initialize grid with 2 virtual sites at the top and bottom
        grid = new boolean[n * n + 2];
        percUnionFind = new WeightedQuickUnionUF(n * n + 2);    // includes virtual top and bottom
        fullUnionFind = new WeightedQuickUnionUF(n * n + 1);    // includes only virtual top

        // initialize beginning state
        grid[0] = OPEN;
        for (int i=1; i<n*n+2; i++) {
            grid[i] = BLOCKED;
        }
    }

    // validate row, col indices
    private void checkSiteIndices(int row, int col) {
        if (row < 1 || row > size)
            throw new IllegalArgumentException(
                String.format("Row index %s is out of bounds", row)
            );

        if (col < 1 || col > size)
            throw new IllegalArgumentException(
                String.format("Column index %s is out of bounds", col)
            );
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkSiteIndices(row, col);

        // do nothing for open site
        if (isOpen(row, col))
            return;

        grid[serializeIndex(row, col)] = OPEN;
        int currentSite = serializeIndex(row, col);

        // connect upper site
        if (row > 1 && isOpen(row-1, col)) {
            percUnionFind.union(currentSite, serializeIndex(row-1, col));
            fullUnionFind.union(currentSite, serializeIndex(row-1, col));
        }

        // connect lower site
        if (row < size && isOpen(row+1, col)) {
            percUnionFind.union(currentSite, serializeIndex(row+1, col));
            fullUnionFind.union(currentSite, serializeIndex(row+1, col));
        }

        // connect left site
        if (col > 1 && isOpen(row, col-1)) {
            percUnionFind.union(currentSite, serializeIndex(row, col-1));
            fullUnionFind.union(currentSite, serializeIndex(row, col-1));
        }

        // connect right site
        if (col < size && isOpen(row, col+1)) {
            percUnionFind.union(currentSite, serializeIndex(row, col+1));
            fullUnionFind.union(currentSite, serializeIndex(row, col+1));
        }

        // connect edge
        if (row == 1) {
            percUnionFind.union(currentSite, 0);
            fullUnionFind.union(currentSite, 0);
        }

        if (row == size) {
            percUnionFind.union(currentSite, size * size + 1);
        }

    }

    // convert 2d indices to 1d
    private int serializeIndex(int row, int col) {
        return (row - 1) * size + col;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkSiteIndices(row, col);

        if (grid[serializeIndex(row, col)] == OPEN)
            return true;

        else
            return false;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkSiteIndices(row, col);

        return fullUnionFind.find(serializeIndex(row, col)) == fullUnionFind.find(0);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int numOpenSites = 0;
        for (int i=1; i<size*size+1; i++)
            if (grid[i] == OPEN)
                numOpenSites += 1;

        return numOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return percUnionFind.find(size*size+1) == percUnionFind.find(0);
    }

    // test client (optional)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Percolation grid = new Percolation(n);

        while (!grid.percolates()) {

            // open a random site
            int row = StdRandom.uniformInt(n) + 1;
            int col = StdRandom.uniformInt(n) + 1;

            if (!grid.isOpen(row, col))
                grid.open(row, col);
        }

        int numOpenSites = grid.numberOfOpenSites();
        double pctOpenSites = numOpenSites * 1.0 / (n * n);

        StdOut.println("Percentage of open sites: " + pctOpenSites);
    }
}