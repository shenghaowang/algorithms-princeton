import java.lang.Math;


public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);

        int x = 0;
        int y = 0;

        int numSteps = 0;

        while (Math.abs(x) + Math.abs(y) < r) {

            // update step counter
            numSteps += 1;

            // print the coordinate
            System.out.println("(" + x + ", " + y + ")");

            // update the coordinate
            double rand = Math.random();

            if (rand < 0.25) x++;
            else if (rand < 0.5) x--;
            else if (rand < 0.75) y++;
            else y--;
        }

        System.out.println("(" + x + ", " + y + ")");
        System.out.println("steps = " + numSteps);
    }
}