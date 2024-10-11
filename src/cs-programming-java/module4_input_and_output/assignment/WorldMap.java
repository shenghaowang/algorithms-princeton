/******************************************************************************
 *  Compilation:  javac-introcs WorldMap.java
 *  Execution:    java-introcs WorldMap < canada.txt
 *  Execution:    java-introcs WorldMap < singapore.txt
 *
 *  Dependencies: StdIn.java, StdDraw.java
 *
 ******************************************************************************/

public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int numVertices = StdIn.readInt();

            double[] x = new double[numVertices];
            double[] y = new double[numVertices];
            for (int i = 0; i < numVertices; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }

        StdDraw.show();
    }
}