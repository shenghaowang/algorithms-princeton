/******************************************************************************
 *  Implement a color client example: Albers squares
 *
 *  Compilation:  javac-introcs AlbersSquares.java
 *  Execution:    java-introcs AlbersSquares 0 64 128 105 105 105
 *
 *  Dependencies: StdDraw.java
 *
 ******************************************************************************/
import java.awt.Color;


public class AlbersSquares {
    public static void main(String[] args) {
        // create first color
        int r1 = Integer.parseInt(args[0]);
        int g1 = Integer.parseInt(args[1]);
        int b1 = Integer.parseInt(args[2]);
        Color c1 = new Color(r1, g1, b1);

        // create second color
        int r2 = Integer.parseInt(args[3]);
        int g2 = Integer.parseInt(args[4]);
        int b2 = Integer.parseInt(args[5]);
        Color c2 = new Color(r2, g2, b2);

        // draw first square
        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(.25, .5, .2);
        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(.25, .5, .1);

        // draw second square
        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(.75, .5, .2);
        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(.75, .5, .1);
    }
}