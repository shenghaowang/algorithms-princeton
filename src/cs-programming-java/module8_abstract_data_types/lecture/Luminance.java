/******************************************************************************
 *  Calculate the monochrome luminance of a color.
 *
 *  The monochrome luminace of a color quantifies its effective brightness.
 *  NTSC standard formula for luminance: 0.299r + 0.587g + 0.114b
 *
 *  Compilation:  javac-introcs Luminance.java
 *  Execution:    java-introcs Luminance 0 64 128
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

import java.awt.Color;


public class Luminance {
    public static double lum(Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        return 0.299*r + 0.587*g + 0.114*b;
    }

    // absolute value of difference in luminosity should be > 128
    public static boolean compatible(Color a, Color b) {
        return Math.abs(lum(a) - lum(b)) >= 128.0;
    }

    // convert colors to grayscale values
    public static Color toGray(Color c) {
        // when all three R, G, and B values are the same, resulting
        // color is on grayscale from 0 (black) to 255 (white)
        int y = (int) (Math.round(lum(c)));
        Color gray = new Color(y, y, y);
        return gray;
    }

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int g = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        Color c = new Color(r, g, b);
        StdOut.println(Math.round(lum(c)));
    }
}