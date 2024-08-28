/******************************************************************************
 *  Compilation:  javac-introcs Checkerboard.java
 *  Execution:    java-introcs Checkerboard 8
 *  Execution:    java-introcs Checkerboard 5
 *
 *  Dependencies: StdDraw.java
 *
 ******************************************************************************/

public class Checkerboard {
    public static void main(String[] args) {
        double n = (double)Integer.parseInt(args[0]);

        // draw the canvas
        StdDraw.setScale(0.0, n);

        // draw squares
        for (double x = 0.5; x < n; x++)
            for (double y = 0.5; y < n; y++) {
                if ((x + y) % 2 == 1)
                    StdDraw.setPenColor(StdDraw.BLUE);
                else
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);

                StdDraw.filledSquare(x, y, 0.5);
            }
    }
}