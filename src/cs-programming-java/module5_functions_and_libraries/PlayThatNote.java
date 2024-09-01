/******************************************************************************
 *  Compilation:  javac-introcs PlayThatNote.java
 *  Execution:    java-introcs PlayThatNote 2.0 < elise.txt
 *  Execution:    java-introcs PlayThatNote 1.0 < elise.txt
 *
 *  Dependencies: StdAudio.java
 *
 ******************************************************************************/

public class PlayThatNote {
    public static double[] tone(double hz, double duration) {
        // hz: pitch; duration: length of the music to play in seconds
        // 44100 is a common sampling frequency
        int N = (int) (44100 * duration);
        double[] a = new double[N+1];

        for (int i = 0; i <= N; i++)
            // sample a sine wave
            a[i] = Math.sin(2 * Math.PI * i * hz / 44100);

        return a;
    }

    public static void main(String[] args) {
        double tempo = Double.parseDouble(args[0]);
        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble() * tempo;

            // compute pitch
            double hz = 440 * Math.pow(2, pitch / 12.0);
            double[] a = PlayThatNote.tone(hz, duration);
            StdAudio.play(a);
        }

        StdAudio.drain();
    }
}