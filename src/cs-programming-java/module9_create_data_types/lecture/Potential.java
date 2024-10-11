/******************************************************************************
 *  Point charge client: Potential visualization
 *
 *
 *  Compilation:  javac-introcs Potential.java
 *  Execution:    java-introcs Potential < charges3.txt
 *  Execution:    java-introcs Potential < charges9.txt
 *
 *  Dependencies: Charge.java, Picture.java
 *
 ******************************************************************************/

import java.awt.Color;


public class Potential {
    // read point charges into an array
    public static Charge[] readCharges() {
        int N = StdIn.readInt();
        Charge[] a = new Charge[N];
        for (int i = 0; i < N; i++) {
            double x0 = StdIn.readDouble();
            double y0 = StdIn.readDouble();
            double q0 = StdIn.readDouble();
            a[i] = new Charge(x0, y0, q0);
        }

        return a;
    }

    // convert potential values to a color
    public static Color toColor(double V) {
        V = 128 + V / 2.0e10;

        // convert V to integer
        int t = 0;
        if (V > 255) t = 255;
        else if (V >= 0) t = (int) V;
        // t = t*37 % 255;
        return new Color(t, t, t);
    }

    public static void main(String[] args) {
        Charge[] a = readCharges();
        int SIZE = 800;
        Picture pic = new Picture(SIZE, SIZE);

        for (int col = 0; col < SIZE; col++)
            for (int row = 0; row < SIZE; row++) {
                double V = 0.0;
                for (int k = 0; k < a.length; k++) {
                    double x = 1.0 * col / SIZE;
                    double y = 1.0 * row / SIZE;
                    V += a[k].potentialAt(x, y);
                }
                pic.set(col, SIZE-1-row, toColor(V));
            }

        pic.show();
    }
}