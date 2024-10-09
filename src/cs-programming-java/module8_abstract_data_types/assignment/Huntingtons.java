/******************************************************************************
 *  Analyze a DNA string for Huntington’s disease and produce a diagnosis.
 *
 *  Compilation:  javac-introcs Huntingtons.java
 *  Execution:    java-introcs Huntingtons < repeats4.txt
 *
 *  Dependencies: In.java, StdOut.java
 ******************************************************************************/
public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int maxRepeats = 0;
        int repeats = 0;

        int i = 0;
        while (i < dna.length() - 2) {
            if (dna.substring(i, i + 3).equals("CAG")) {
                repeats++;
                if (repeats > maxRepeats) maxRepeats = repeats;
                i += 3;
            } else {
                repeats = 0;
                i++;
            }
        }

        return maxRepeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        s = s.replace(" ", "");
        s = s.replace("\n", "");
        s = s.replace("\t", "");

        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9) return "not human";
        else if (maxRepeats <= 35) return "normal";
        else if (maxRepeats <= 39) return "high risk";
        else if (maxRepeats <= 180) return "Huntington's";
        else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In in = new In(args[0]);
        String dna = in.readAll();

        dna = removeWhitespace(dna);
        int maxRepeats = maxRepeats(dna);

        StdOut.println("max repeats = " + maxRepeats);
        StdOut.println(diagnose(maxRepeats));
    }

}