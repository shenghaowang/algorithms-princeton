/******************************************************************************
 *  Reve’s puzzle
 *
 *  Takes an integer command-line argument n and prints a solution to
 *  Reve’s puzzle.
 *
 *  Assume that the the discs are labeled in increasing order of size from
 *  1 to n and that the poles are labeled A, B, C, and D, with A representing
 *  the starting pole and D representing the destination pole.
 *
 *  Compilation:  javac-introcs RevesPuzzle.java
 *  Execution:    java-introcs RevesPuzzle 3
 *  Execution:    java-introcs RevesPuzzle 4
 *  Execution:    java-introcs RevesPuzzle 5
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

 public class RevesPuzzle {
    private static void reve(int n, String from, String to, String aux1, String aux2) {
        if (n == 0) return;

        int k = (int) (Math.round(n + 1 - Math.sqrt(2 * n + 1)));

        // Move the k smallest discs to a single pole
        // other than the start or destination poles. (=> aux1)
        reve(k, from, aux1, to, aux2);

        // Move the remaining n−k disks to the destination pole
        // without using the pole that now contains the smallest k discs.
        hanoi(n, k, from, to, aux2);

        // Move the k smallest discs to the destination pole.
        reve(k, aux1, to, from, aux2);
    }

    // 3-pole towers operation
    private static void hanoi(int n, int k, String from, String to, String aux) {
        if (n == k) return;

        // Move n-1 disks from rod A to rod B, using rod C as an auxiliary rod.
        hanoi(n-1, k, from, aux, to);

        // Move the nth disk from rod A to rod C.
        StdOut.println("Move disc " + n + " from " + from + " to " + to);

        // Move the n-1 disks from rod B to rod C, using rod A as an auxiliary rod.
        hanoi(n-1, k, aux, to, from);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reve(n, "A", "D", "B", "C");
    }
}