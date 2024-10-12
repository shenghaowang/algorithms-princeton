/******************************************************************************
 *  Example client of BarChart
 *
 *  Compilation:  javac-introcs BarRacer.java
 *  Execution:    java-introcs BarRacer cities.txt 10
 *  Execution:    java-introcs BarRacer movies.txt 10
 *
 *  Dependencies: BarChart.java, In.java, StdDraw.java
 ******************************************************************************/
import java.util.Arrays;
import java.util.Collections;


public class BarRacer {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int top = Integer.parseInt(args[1]);

        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();

        StdOut.println(title);
        StdOut.println(xAxis);
        StdOut.println(source);

        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        BarChart chart = new BarChart(title, xAxis, source);

        while (!in.isEmpty()) {
            String blankLine = in.readLine(); // skip blank line
            int numBars = Integer.parseInt(in.readLine());
            Bar[] bars = new Bar[numBars];

            for (int i = 0; i < numBars; i++) {
                // StdOut.println(in.readLine());
                String[] data = in.readLine().split(",");
                if (i == 0) {
                    String year = data[0];
                    chart.setCaption(year);
                }

                String name = data[1];
                int value = Integer.parseInt(data[3]);
                String category = data[4];

                bars[i] = new Bar(name, value, category);
            }

            // sort the bars in descending order
            Arrays.sort(bars, Collections.reverseOrder());

            // add the top bars to the chart
            for (int i = 0; i < top; i++) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }

            // draw the bar chart
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(50);
            chart.reset();
        }
    }
}