/******************************************************************************
 *  Implement a clock to represent time on a 24-hour clock,
 *  such as 00:00, 13:30, or 23:59. Time is measured in hours (00–23)
 *  and minutes (00–59).
 *
 *  Compilation:  javac-introcs Clock.java
 *  Execution:    java-introcs Clock
 *
 *  Dependencies: StdIn.java, StdOut.java
 *
 ******************************************************************************/

public class Clock {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;

    private int hours, minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        validate(h, m);

        hours = h;
        minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        String regex = "^\\d{2}:\\d{2}";
        if (!s.matches(regex))
            throw new IllegalArgumentException("the time format must be HH:MM");

        String[] hhmm = s.split(":");
        int h = Integer.parseInt(hhmm[0]);
        int m = Integer.parseInt(hhmm[1]);

        validate(h, m);

        hours = h;
        minutes = m;
    }

    private static void validate(int h, int m) {
        if (h < 0 || h >= HOURS_PER_DAY)
            throw new IllegalArgumentException("Invalid hour value: " + h);

        if (m < 0 || m >= MINUTES_PER_HOUR)
            throw new IllegalArgumentException("Invalid minute value: " + m);
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d", hours) + ":" + String.format("%02d", minutes);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hours < that.hours)
            return true;

        if (this.hours == that.hours && this.minutes < that.minutes)
            return true;

        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (minutes == MINUTES_PER_HOUR - 1) {
            if (hours == HOURS_PER_DAY - 1) {
                hours = 0;
                minutes = 0;
            } else {
                hours++;
                minutes = 0;
            }
        } else {
            minutes++;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("Invalid delta value: " + delta);

        for (int i = 0; i < delta; i++)
            tic();
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock c1 = new Clock(23, 59);
        Clock c2 = new Clock("13:30");

        StdOut.println(c1);
        StdOut.println(c2);

        StdOut.println(c1.isEarlierThan(c2));
        StdOut.println(c2.isEarlierThan(c1));

        c1.tic();
        StdOut.println(c1);

        c2.toc(30);
        StdOut.println(c2);
    }
}