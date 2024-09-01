/******************************************************************************
 *  Compute activation functions for neural networks
 *
 *  Compilation:  javac-introcs ActivationFunction.java
 *  Execution:    java-introcs ActivationFunction 0.0
 *  Execution:    java-introcs ActivationFunction 1.0
 *  Execution:    java-introcs ActivationFunction -0.5
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x))  return Double.NaN;
        if (x < 0)  return 0.0;
        else if (x == 0)  return 1 / 2;
        else  return 1;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x))  return Double.NaN;
        return 1 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x))  return Double.NaN;
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x))  return Double.NaN;
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x))  return Double.NaN;
        if (x <= -2)  return -1;
        else if (x > -2 && x < 0)  return x + Math.pow(x, 2) / 4;
        else if (x >= 0 && x < 2)  return x - Math.pow(x, 2) / 4;
        else  return 1;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println(String.format("heaviside(%s) = %s", x, heaviside(x)));
        StdOut.println(String.format("  sigmoid(%s) = %s", x, sigmoid(x)));
        StdOut.println(String.format("     tanh(%s) = %s", x, tanh(x)));
        StdOut.println(String.format(" softsign(%s) = %s", x, softsign(x)));
        StdOut.println(String.format("     sqnl(%s) = %s", x, sqnl(x)));
    }
}