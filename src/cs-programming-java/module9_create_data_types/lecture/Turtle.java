/******************************************************************************
 *  Implementation of turtle graphics
 *
 *
 *  Compilation:  javac-introcs Turtle.java
 *  Execution:    java-introcs Turtle
 *
 ******************************************************************************/

public class Turtle {
    // instance variables are not final
    private double x, y;   // turtle position
    private double angle;  // turtle direction

    public Turtle(double x0, double y0, double a0) {
        x = x0;
        y = y0;
        angle = a0;
    }

    public void turnLeft(double delta) {
        angle += delta;
    }

    public void goForward(double d) {
        double oldx = x;
        double oldy = y;
        x += d * Math.cos(Math.toRadians(angle));
        y += d * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y);
    }

    public static void main(String[] args) {
        Turtle turtle = new Turtle(0.0, 0.0, 0.0);
        turtle.goForward(1.0);
        turtle.turnLeft(120.0);
        turtle.goForward(1.0);
        turtle.turnLeft(120.0);
        turtle.goForward(1.0);
        turtle.turnLeft(120.0);
    }
}