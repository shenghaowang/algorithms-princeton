/******************************************************************************
 *  OOP example: point charge implementation
 *
 *
 *  Compilation:  javac-introcs Charge.java
 *  Execution:    java-introcs Charge
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class Charge {

    /*
     *  Instance variables define data-type values.
     *  - private denies client access and therefore makes data type abstract.
     *  - final disallows any change in value and documents that data type is immutable.
     */
    private final double rx, ry;   // position
    private final double q;        // charge

    // Constructor create and initialize new objects.
    public Charge(double x0, double y0, double q0) {
        rx = x0;
        ry = y0;
        q  = q0;
    }

    public double potentialAt(double x, double y) {
        double k = 8.99e09;
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx * dx + dy * dy);
    }

    public String toString() {
        return q + " at " + "(" + rx + ", " + ry + ")";
    }

    public static void main(String[] args) {
        /*
         *  Client use new to invoke constructors.
         *  - Pass arguments as in a method call.
         *  - Reture value is reference to new object.
         */
        Charge c = new Charge(.72, .31, 20.1);
        StdOut.println(c);  // automatically invokes c.toString()
        StdOut.printf("%6.2e\n", c.potentialAt(.42, .71));
    }
}