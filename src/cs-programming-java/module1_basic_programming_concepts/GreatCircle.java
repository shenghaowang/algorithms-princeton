import java.lang.Math;


public class GreatCircle {

    public static void main(String[] args) {

        final double EARTH_RADIUS = 6371.0;

        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);

        double dx = Math.toRadians(x2 - x1);
        double dy = Math.toRadians(y2 - y1);

        x1 = Math.toRadians(x1);
        x2 = Math.toRadians(x2);

        double a = Math.pow(Math.sin(dx / 2), 2);
        double b = Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin(dy / 2), 2);
        double res = 2 * EARTH_RADIUS * Math.asin(Math.sqrt(a + b));

        System.out.println(res + " kilometers");
    }

}