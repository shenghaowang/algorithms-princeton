public class Minesweeper {
    public static void main(String[] args) {

        // number of rows
        int m = Integer.parseInt(args[0]);

        // number of columns
        int n = Integer.parseInt(args[1]);

        // number of mines
        int k = Integer.parseInt(args[2]);

        // declare grid
        int[][] grid = new int[m][n];

        int count = 0;
        while (count < k) {
            int x = (int)(Math.random() * (m - 1));
            int y = (int)(Math.random() * (n - 1));

            if (grid[x][y] == 0) {
                grid[x][y]++;
                count++;
            }
        }

        // print the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    System.out.print("*  ");
                    continue;
                }

                // count the number of mines
                int numMines = 0;
                if (i > 0 && grid[i-1][j] == 1)
                    numMines++;

                if (i < m - 1 && grid[i+1][j] == 1)
                    numMines++;

                if (j > 0 && grid[i][j-1] == 1)
                    numMines++;

                if (j < n - 1 && grid[i][j+1] == 1)
                    numMines++;

                if (i > 0 && j > 0 && grid[i-1][j-1] == 1)
                    numMines++;

                if (i < m - 1 && j > 0 && grid[i+1][j-1] == 1)
                    numMines++;

                if (i > 0 && j < n - 1 && grid[i-1][j+1] == 1)
                    numMines++;

                if (i < m - 1 && j < n - 1 && grid[i+1][j+1] == 1)
                    numMines++;

                System.out.print(numMines + "  ");
            }

            System.out.println();
        }
    }
}