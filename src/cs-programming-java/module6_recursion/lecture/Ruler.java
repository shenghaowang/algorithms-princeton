/******************************************************************************
 *  Create a subdivisions of a ruler to 1 / 2^n inches
 *
 *  Compilation:  javac-introcs Ruler.java
 *  Execution:    java-introcs Ruler 2
 *  Execution:    java-introcs Ruler 3
 *  Execution:    java-introcs Ruler 4
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class Ruler {
    public static String ruler(int n) {
        if (n == 0)  return " ";
        return ruler(n-1) + n + ruler(n-1);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(ruler(n));
    }
}