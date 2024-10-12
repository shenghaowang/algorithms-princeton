/******************************************************************************
 *  Implement a bar data type that aggregates related information
 *  for use in a bar chart.
 *
 *  Compilation:  javac-introcs Bar.java
 *  Execution:    java-introcs Bar
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class Bar implements Comparable<Bar> {
    // instance variables
    private final String name;
    private final int value;
    private final String category;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (name == null)
            throw new IllegalArgumentException("name cannot be null");

        if (value < 0)
            throw new IllegalArgumentException("value cannot be negative");

        if (category == null)
            throw new IllegalArgumentException("category cannot be null");

        this.name = name;
        this.value = value;
        this.category = category;
    }

    // Returns the name of this bar.
    public String getName() {
        return this.name;
    }

    // Returns the value of this bar.
    public int getValue() {
        return this.value;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return this.category;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
        if (that == null)
            throw new NullPointerException("invalid Bar object");

        if (this.value < that.value) {
            return -1;
        } else if (this.value > that.value) {
            return 1;
        } else {
            return 0;
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        Bar bar1 = new Bar("Beijing",     22674, "East Asia");
        Bar bar2 = new Bar("Cairo",       19850, "Middle East");

        StdOut.println(bar1.compareTo(bar2));
        StdOut.println(bar2.compareTo(bar1));
    }
}