/******************************************************************************
 *  Convert an integer to binary
 *
 *  Compilation:  javac-introcs Binary.java
 *  Execution:    java-introcs Binary 6
 *  Execution:    java-introcs Binary 37
 *  Execution:    java-introcs Binary 999999
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class Binary {
    public static String convert(int N) {
        if (N == 1)  return "1";
        return convert(N/2) + (N % 2);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdOut.println(convert(N));
    }
}