import java.lang.Math;


public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        // declare counter for trial
        int i = 0;
        int totalSteps = 0;

        while (i < trials) {
            int x = 0;
            int y = 0;

            int numSteps = 0;

            while (Math.abs(x) + Math.abs(y) < r) {

                // update the coordinate
                double rand = Math.random();

                if (rand < 0.25) x++;
                else if (rand >= 0.25 && rand < 0.5) x--;
                else if (rand >= 0.5 && rand < 0.75) y++;
                else y--;

                numSteps += 1;
            }

            totalSteps += numSteps;
            i++;
        }

        System.out.println("average number of steps = " + (totalSteps * 1.0 / trials));
    }
}