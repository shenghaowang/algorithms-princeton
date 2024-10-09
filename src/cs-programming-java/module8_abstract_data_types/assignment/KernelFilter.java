/******************************************************************************
 *  Apply various kernel filters to process images.
 *
 *  A kernel filter modifies the pixels in an image by replacing each pixel
 *  with a linear combination of its neighboring pixels. The matrix that
 *  characterizes the linear combination is known as the kernel.
 *
 *  Compilation:  javac-introcs KernelFilter.java
 *  Execution:    java-introcs KernelFilter ../baboon.png
 *
 *  Dependencies: Picture.java
 ******************************************************************************/

import java.awt.Color;


public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        // declare kernel filter
        double[][] kernel = { {0.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 0.0} };

        return applyKernel(picture, kernel);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        // declare kernel filter
        double[][] kernel = {
            {1.0 / 16, 2.0 / 16, 1.0 / 16},
            {2.0 / 16, 4.0 / 16, 2.0 / 16},
            {1.0 / 16, 2.0 / 16, 1.0 / 16} };

        return applyKernel(picture, kernel);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        // declare kernel filter
        double[][] kernel = { {0.0, -1.0, 0.0}, {-1.0, 5.0, -1.0}, {0.0, -1.0, 0.0} };

        return applyKernel(picture, kernel);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        // declare kernel filter
        double[][] kernel = { {-1.0, -1.0, -1.0}, {-1.0, 8.0, -1.0}, {-1.0, -1.0, -1.0} };

        return applyKernel(picture, kernel);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        // declare kernel filter
        double[][] kernel = { {-2.0, -1.0, 0.0}, {-1.0, 1.0, 1.0}, {0.0, 1.0, 2.0} };

        return applyKernel(picture, kernel);
    }

    public static Picture applyKernel(Picture picture, double[][] kernel) {
        int w = picture.width();
        int h = picture.height();
        Picture target = new Picture(w, h);

        int halfKernelSize = (kernel.length - 1) / 2;

        for (int tcol = 0; tcol < w; tcol++)
            for (int trow = 0; trow < h; trow++) {

                // apply kernel filter
                double r, g, b;
                r = g = b = 0.0;

                for (int i = -halfKernelSize; i <= halfKernelSize; i++)
                    for (int j = -halfKernelSize; j <= halfKernelSize; j++) {

                        // extract source pixel
                        int scol = tcol + i;
                        if (scol < 0) scol = w + scol;
                        if (scol >= w) scol = scol % w;

                        int srow = trow + j;
                        if (srow < 0) srow = h + srow;
                        if (srow >= h) srow = srow % h;

                        Color scolor = picture.get(scol, srow);
                        double k = kernel[i + halfKernelSize][j + halfKernelSize];

                        r += k * scolor.getRed();
                        g += k * scolor.getGreen();
                        b += k * scolor.getBlue();
                    }

                Color tcolor = new Color(clamp(r), clamp(g), clamp(b));
                target.set(tcol, trow, tcolor);
            }

        return target;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        // declare kernel filter
        double[][] kernel = new double[9][9];
        for (int i = 0; i < 9; i++)
            kernel[i][i] = 1.0 / 9;

        return applyKernel(picture, kernel);
    }

    private static int clamp(double value) {
        int res = (int) Math.round(value);
        if (res < 0) return 0;
        if (res > 255) return 255;
        return res;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        String filename = args[0];
        Picture source = new Picture(filename);

        Picture target = motionBlur(source);
        target.show();
    }

}