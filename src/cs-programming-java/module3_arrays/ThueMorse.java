import java.lang.Math;


public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[][] arr = new int[n][n];

        // iteratively fill in rows
        for (int row = 0; row < n; row++) {
            if (row > 0)
                arr[row][0] = arr[0][row];

            int j = 0;
            for (int i = 1; i < n; i++) {
                if (i >= Math.pow(2, j))
                    j++;

                int ref = i - (int)Math.pow(2, j - 1);
                arr[row][i] = Math.abs(1 - arr[row][ref]);
            }
        }

        // print the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0)
                    System.out.print("+  ");

                else
                    System.out.print("-  ");
            }

            System.out.println();
        }
    }
}