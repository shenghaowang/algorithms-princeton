/******************************************************************************
 *  Determine the size of the largest contiguous square submatrix
 *  containing only 1s.
 *
 *  Compilation:  javac-introcs MaximumSquareSubmatrix.java
 *  Execution:    java-introcs MaximumSquareSubmatrix < square6.txt
 *  Execution:    java-introcs MaximumSquareSubmatrix < square7.txt
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int maxSize = 0;
        int dim = a[0].length;

        for (int i = 0; i < dim; i++)
            for (int j = 0; j < dim; j++)
                if (a[i][j] == 1 && dim - i > maxSize && dim - j > maxSize) {
                    int size = 1;
                    while (i + size < dim && j + size < dim) {
                        boolean isSquare = true;
                        for (int k = i; k <= i + size; k++)
                            for (int l = j; l <= j + size; l++)
                                if (a[k][l] != 1) {
                                    isSquare = false;
                                    break;
                                }

                        if (isSquare)
                            size++;
                        else
                            break;
                    }

                    if (size > maxSize)
                        maxSize = size;
                }

        return maxSize;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int dim = StdIn.readInt();
        int a[][] = new int[dim][dim];

        for (int i = 0; i < dim; i++)
            for (int j = 0; j < dim; j++)
                a[i][j] = StdIn.readInt();

        StdOut.println(size(a));
    }
}