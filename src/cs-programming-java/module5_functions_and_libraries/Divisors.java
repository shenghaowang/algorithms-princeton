/******************************************************************************
 *  Compute the greatest common divisor and related functions on integers
 *
 *  Compilation:  javac-introcs Divisors.java
 *  Execution:    java-introcs Divisors 1440 408
 *  Execution:    java-introcs Divisors 987 610
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        if (a * b == 0)  return Math.max(a, b);
        else  return gcd(Math.min(a, b), Math.max(a, b) % Math.min(a, b));
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        // GCD of any two numbers is never negative or 0
        return Math.abs(a) * Math.abs(b) / gcd(a, b);
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int count = 0;
        int i = 1;

        while (i < n) {
            if (areRelativelyPrime(i, n) == true)
                count++;
            i++;
        }

        return count;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        StdOut.println(String.format("gcd(%s, %s) = %s", a, b, gcd(a, b)));
        StdOut.println(String.format("lcm(%s, %s) = %s", a, b, lcm(a, b)));
        StdOut.println(String.format("areRelativelyPrime(%s, %s) = %s", a, b, areRelativelyPrime(a, b)));
        StdOut.println(String.format("totient(%s) = %s", a, totient(a)));
        StdOut.println(String.format("totient(%s) = %s", b, totient(b)));
    }
}