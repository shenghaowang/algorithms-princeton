/******************************************************************************
 *  Convert an image to grayscale.
 *
 *
 *  Compilation:  javac-introcs Grayscale.java
 *  Execution:    java-introcs Grayscale ../baboon.png
 *
 *  Dependencies: Picture.java
 *
 ******************************************************************************/

import java.awt.Color;


public class Grayscale {
    public static void main(String[] args) {
        // create a new picture
        Picture pic = new Picture(args[0]);

        for (int col = 0; col < pic.width(); col++)
            for (int row = 0; row < pic.height(); row++) {
                // fill in each pixel with its grayscale equivalent
                Color color = pic.get(col, row);
                Color gray = Luminance.toGray(color);
                pic.set(col, row, gray);
            }

        pic.show();
    }
}