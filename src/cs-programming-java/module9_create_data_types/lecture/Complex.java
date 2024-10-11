/******************************************************************************
 *  ADT for complex numbers
 *
 *
 *  Compilation:  javac-introcs Complex.java
 *  Execution:    java-introcs Complex
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class Complex {
    private final double re;   // the real part
    private final double im;   // the imaginary part

    // constructor
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    public Complex plus(Complex b) {
        double real = re + b.re;
        double imag = im + b.im;
        return new Complex(real, imag);
    }

    public Complex times(Complex b) {
        double real = re * b.re - im * b.im;
        double imag = re * b.im + im * b.re;
        return new Complex(real, imag);
    }

    public double abs() {
        return Math.sqrt(re * re + im * im);
    }

    public String toString() {
        return re + " + " + im + "i";
    }

    public static void main(String[] args) {
        Complex a = new Complex(3.0, 4.0);
        Complex b = new Complex(-2.0, 3.0);
        StdOut.println("a = " + a);
        StdOut.println("b = " + b);
        StdOut.println("a * b = " + a.times(b));
    }
}