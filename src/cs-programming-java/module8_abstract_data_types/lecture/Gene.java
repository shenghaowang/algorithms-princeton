/******************************************************************************
 *  Determine whether a given string is a potential gene which
 *  starts with "ATG" and ends with "TAA", "TAG", or "TGA"
 *
 *  Compilation:  javac-introcs Gene.java
 *  Execution:    java-introcs Gene ATGCATAGCGCATAG
 *  Execution:    java-introcs Gene ATGCGCTGCGTCTGTACTAG
 *  Execution:    java-introcs Gene ATGCCGTGACGTCTGTACTAG
 *
 *  Dependencies: StdOut.java
 *
 ******************************************************************************/

public class Gene {
    // determine whether a given string is a potential gene which
    // starts with "ATG" and ends with "TAA", "TAG", or "TGA"
    public static boolean isPotentialGene(String dna) {
        if (dna.length() % 3 != 0) return false;
        if (!dna.startsWith("ATG")) return false;

        for (int i = 0; i < dna.length() - 3; i+=3) {
            String codon = dna.substring(i, i+3);

            // check if the gene concludes before the end of string
            if (codon.equals("TAA")) return false;
            if (codon.equals("TAG")) return false;
            if (codon.equals("TGA")) return false;
        }
        if (dna.endsWith("TAA")) return true;
        if (dna.endsWith("TAG")) return true;
        if (dna.endsWith("TGA")) return true;

        return false;
    }

    public static void main(String[] args) {
        StdOut.println(isPotentialGene(args[0]));
    }
}