public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        /* In the extreme case, n + 1 persons are required
           until 2 persons share a birthday
        */
        int[] counts = new int[n+2];

        for (int i = 0; i < trials; i++) {
            int[] birthdays = new int[n];
            int numPersons = 0;

            while (numPersons < n + 1) {
                int r = (int)(Math.random() * n);
                // System.out.println("r = " + r);
                birthdays[r]++;
                numPersons++;

                if (birthdays[r] > 1) {
                    counts[numPersons]++;
                    break;
                }
            }
        }

        // calculate cumulative fractions
        double[] fractions = new double[n+2];
        int cumCounts = 0;
        for (int i = 0; i < n+2; i++) {
            cumCounts += counts[i];
            fractions[i] = cumCounts * 1.0 / trials;
        }

        int i = 1;
        while (fractions[i] <= 0.5) {
            System.out.println(i + "\t" + counts[i] + "\t" + fractions[i]);
            i++;
        }
        System.out.println(i + "\t" + counts[i] + "\t" + fractions[i]);
    }
}