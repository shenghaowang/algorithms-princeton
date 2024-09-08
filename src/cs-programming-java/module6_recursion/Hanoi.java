/******************************************************************************
 *  Towers of Hanoi: recursive solution
 *
 *  Compilation:  javac-introcs Hanoi.java
 *  Execution:    java-introcs Hanoi 3
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class Hanoi {

    // left: instructions for moving n discs to
    // the left (if left is true) or right (if left is false)
    public static String hanoi(int n, boolean left) {
        if (n == 0) return " ";
        String move;
        if (left) move = n + "L";
        else      move = n + "R";
        return hanoi(n-1, !left) + move + hanoi(n-1, !left);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(hanoi(n, false));
    }
}