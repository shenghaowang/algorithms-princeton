/******************************************************************************
 *  Implement a color in hue–saturation–brightness (HSB) format.
 *
 *  Compilation:  javac-introcs ColorHSB.java
 *
 *  Execution:    java-introcs ColorHSB 25 84 97 < web.txt
 *  Execution:    java-introcs ColorHSB 350 100 45 < web.txt
 *  Execution:    java-introcs ColorHSB 25 84 97 < wiki.txt
 *
 *  Dependencies: StdIn.java, StdOut.java
 *
 ******************************************************************************/

public class ColorHSB {
    private static final int MAX_HUE = 359;
    private static final int MAX_SAT_BRI = 100;

    private final int hue, saturation, brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > MAX_HUE)
            throw new IllegalArgumentException("Invalid hue value: " + h);

        if (s < 0 || s > MAX_SAT_BRI)
            throw new IllegalArgumentException("Invalid saturation value: " + s);

        if (b < 0 || b > MAX_SAT_BRI)
            throw new IllegalArgumentException("Invalid brightness value: " + b);

        hue = h;
        saturation = s;
        brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (saturation == 0 || brightness == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null)
            throw new IllegalArgumentException("ColorHSB is null");

        int dh = (int) Math.min(Math.pow(this.hue - that.hue, 2), Math.pow(360 - Math.abs(this.hue - that.hue), 2));
        int ds = (int) Math.pow(this.saturation - that.saturation, 2);
        int db = (int) Math.pow(this.brightness - that.brightness, 2);

        return dh + ds + db;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h0 = Integer.parseInt(args[0]);
        int s0 = Integer.parseInt(args[1]);
        int b0 = Integer.parseInt(args[2]);

        ColorHSB c0 = new ColorHSB(h0, s0, b0);
        int minDistance = Integer.MAX_VALUE;

        ColorHSB closestColor = null;
        String closestColorName = "";

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int hx = StdIn.readInt();
            int sx = StdIn.readInt();
            int bx = StdIn.readInt();

            ColorHSB cx = new ColorHSB(hx, sx, bx);
            int distance = c0.distanceSquaredTo(cx);

            if (distance < minDistance) {
                minDistance = distance;
                closestColorName = name;
                closestColor = cx;
            }
        }

        StdOut.println(closestColorName + " " + closestColor.toString());
    }

}