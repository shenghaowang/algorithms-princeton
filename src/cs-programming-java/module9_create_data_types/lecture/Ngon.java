/******************************************************************************
 *  Turtle client: N-gon
 *
 *
 *  Compilation:  javac-introcs Ngon.java
 *  Execution:    java-introcs Ngon 3
 *  Execution:    java-introcs Ngon 7
 *  Execution:    java-introcs Ngon 1440
 *
 *  Dependencies: Turtle.java
 *
 ******************************************************************************/

public class Ngon {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double angle = 360.0 / N;
        double step = Math.sin(Math.toRadians(angle / 2.0));

        Turtle turtle = new Turtle(0.5, 0.0, angle / 2.0);
        for (int i = 0; i < N; i++) {
            turtle.goForward(step);
            turtle.turnLeft(angle);
        }
    }
}