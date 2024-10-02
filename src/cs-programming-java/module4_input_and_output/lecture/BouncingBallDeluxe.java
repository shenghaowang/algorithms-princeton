/******************************************************************************
 *  Compilation:  javac BouncingBallDeluxe.java
 *  Execution:    java BouncingBallDeluxe
 *  Dependencies: StdDraw.java StdAudio.java
 *                https://introcs.cs.princeton.edu/java/15inout/TennisBall.png
 *                https://introcs.cs.princeton.edu/java/15inout/pipebang.wav
 *
 *  Implementation of a bouncing tennis ball in the box from (-1, -1) to (1, 1),
 *  with sound effects.
 *
 *  % java BouncingBallDeluxe
 *
 ******************************************************************************/

public class BouncingBallDeluxe {
    public static void main(String[] args) {
        double rx = .480, ry = .860;
        double vx = .015, vy = .023;
        double radius = .05;
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

        while(true) {
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.filledSquare(0.0, 0.0, 1.0);

            if (Math.abs(rx + vx) + radius > 1.0) {
                StdAudio.play("pipebang.wav");
                vx = -vx;
            }

            if (Math.abs(ry + vy) + radius > 1.0) {
                StdAudio.play("pipebang.wav");
                vy = -vy;
            }

            rx = rx + vx;
            ry = ry + vy;

            StdDraw.picture(rx, ry, "TennisBall.png");
            StdDraw.pause(20);
        }
    }
}