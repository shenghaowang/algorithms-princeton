/******************************************************************************
 *  Recursive Squares implementation
 *
 *  Takes an integer command-line argument n and
 *  plots a recursive square pattern of order n
 *
 *  Requirements
 *  - The largest square is centered on the canvas and has side length 0.5.
 *  - The side length of each square is one-half that of the next largest square.
 *
 *  Compilation:  javac-introcs RecursiveSquares.java
 *  Execution:    java-introcs RecursiveSquares 2
 *  Execution:    java-introcs RecursiveSquares 4
 *
 *  Dependencies: StdDraw.java
 *
 ******************************************************************************/

public class RecursiveSquares {

    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length/2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length/2);
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;

        // draw the upper left and right squares first
        draw(n - 1, x - length/2, y + length/2, length/2);
        draw(n - 1, x + length/2, y + length/2, length/2);

        // draw the center square
        drawSquare(x, y, length);

        // draw the lower left and right squares
        draw(n - 1, x - length/2, y - length/2, length/2);
        draw(n - 1, x + length/2, y - length/2, length/2);
    }

    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, .5, .5, .5);
    }
}