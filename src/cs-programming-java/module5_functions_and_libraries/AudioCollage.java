/******************************************************************************
 *  Compilation:  javac-introcs AudioCollage.java
 *  Execution:    java-introcs AudioCollage
 *
 *  Dependencies: StdAudio.java
 *
 ******************************************************************************/

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] x = new double[a.length];
        for (int i = 0; i < a.length; i++)
            x[i] = a[i] * alpha;

        return x;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] x = new double[a.length];
        for (int i = 0; i < a.length; i++)
            x[i] = a[a.length - 1 - i];

        return x;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] x = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++)
            x[i] = a[i];

        for (int i = 0; i < b.length; i++)
            x[a.length + i] = b[i];

        return x;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int size = Math.max(a.length, b.length);
        double[] x = new double[size];

        for (int i = 0; i < size; i++) {
            if (i < a.length && i < b.length)
                x[i] = a[i] + b[i];
            else if (i >= a.length)
                x[i] = b[i];
            else
                x[i] = a[i];
        }

        return x;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int N = (int) (a.length / alpha);
        double[] x = new double[N];

        for (int i = 0; i < N; i++)
            x[i] = a[(int)(i * alpha)];

        return x;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] piano = StdAudio.read("piano.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] scratch = StdAudio.read("scratch.wav");

        double[] doublePiano = merge(piano, piano);
        double[] pianoAndBox = mix(doublePiano, beatbox);
        double[] slowDial = changeSpeed(dialup, 1.2);
        double[] revScratch = reverse(scratch);

        double[] newSound = merge(harp, merge(pianoAndBox, merge(slowDial, revScratch)));

        StdAudio.play(newSound);
    }
}