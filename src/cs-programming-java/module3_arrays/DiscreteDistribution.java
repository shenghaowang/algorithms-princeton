public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int N = args.length - 1;
        int[] a = new int[N+1];

        // declare cumulative sum
        int[] S = new int[N+1];

        // fill in the array of the cumulative sum
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(args[i]);
            S[i] = S[i-1] + a[i];
        }

        for (int i = 0; i < m; i++) {

            // pick a random integer uniformly
            int r = (int)(Math.random() * S[N]);

            // search for the index
            int j = 0;
            while (r >= S[j])
                j++;

            System.out.print(j + " ");
        }

        System.out.println();
    }
}