/******************************************************************************
 *  Determine if an integer n is a Ramanujan number if it can be expressed
 *  as the sum of two positive cubes in two different ways.
 *
 *  Compilation:  javac-introcs Ramanujan.java
 *  Execution:    java-introcs Ramanujan 1729
 *  Execution:    java-introcs Ramanujan 3458
 *  Execution:    java-introcs Ramanujan 4104
 *  Execution:    java-introcs Ramanujan 216125
 *  Execution:    java-introcs Ramanujan 9223278330318728221
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int count = 0;
        for (long i = 1; i < Math.cbrt(n); i++) {
            long a = i * i * i;
            long b = n - a;
            long c = (long) Math.cbrt(b);

            if (c > i && a + c * c * c == n) {
                count++;

                if (count == 2)
                    return true;
            }
        }

        return count == 2;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);

        if (isRamanujan(n)) {
            StdOut.println("true");
        } else {
            StdOut.println("false");
        }
    }
}