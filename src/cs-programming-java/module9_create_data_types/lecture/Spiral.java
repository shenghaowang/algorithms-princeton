/******************************************************************************
 *  Turtle client: Spiral Mirabilis
 *
 *
 *  Compilation:  javac-introcs Spiral.java
 *  Execution:    java-introcs Spiral 3 1.2
 *  Execution:    java-introcs Spiral 7 1.2
 *  Execution:    java-introcs Spiral 1440 1.0004
 *
 *  Dependencies: Turtle.java
 *
 ******************************************************************************/

public class Spiral {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double decay = Double.parseDouble(args[1]);
        double angle = 360.0 / N;
        double step = Math.sin(Math.toRadians(angle / 2.0));

        Turtle turtle = new Turtle(0.5, 0.0, angle / 2.0);
        for (int i = 0; i < 10 * N; i++) {
            step /= decay;
            turtle.goForward(step);
            turtle.turnLeft(angle);
        }
    }
}