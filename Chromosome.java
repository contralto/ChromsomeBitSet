import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.lang.Math;


public class Chromosome {
    private BitSet chromo;
    private int genecount;
    private static int gc;
    private boolean hasName = false;
    private String[] alleleNames;

    //creates a Chromosome that has two alleles and 1 gene
    public Chromosome() {
        chromo = new BitSet();
        genecount = 1;
        gc = 1;
    }

    //Chromosome with n genes and 2n alleles; the alleles are unspecified so they are randomly assigned
    Chromosome(int numgenes) {
        genecount = numgenes;
        gc = numgenes;
        chromo = new BitSet(genecount);
        for (int i = 0; i < genecount * 2; i++) {
            chromo.set(i, randomBoolean());
        }
    }

    //Chromosome with n genes and 2n alleles; all genes were defined in the main method
    private Chromosome(int numgenes, BitSet bs) {
        genecount = numgenes;
        gc = numgenes;
        chromo = bs;
    }

    //Chromosome with 2 alleles and 1 gene; each allele is specified
    public Chromosome(boolean allele1, boolean allele2) {
        chromo = new BitSet(2);
        chromo.set(0, allele1);
        chromo.set(1, allele2);
        genecount = 1;
        gc = 1;
    }

    //Creates a chromosome with specified gene count and an array of alleles
    public Chromosome(int numgenes, boolean[] ray) {
        chromo = new BitSet(numgenes * 2);
        genecount = numgenes;
        gc = numgenes;
        for (int i = 0; i < numgenes * 2; i += 2) {
            chromo.set(i, ray[i]);          //represents allele 1 of a certain gene
            chromo.set(i + 1, ray[i + 1]);  //represents allele 2 of a certain gene
        }
    }

    //returns a pseudorandom boolean, representing a dominant (true) or recessive (false) trait
    private static boolean randomBoolean() {
        return Math.random() < 0.5;
    }

    //each gene chooses an allele from each parent; represents
    //independent assortment during sexual reproduction
    static Chromosome cross(Chromosome parent1, Chromosome parent2) {
        BitSet childGenes = new BitSet();
        for (int i = 0; i < getGeneCount() * 2; i += 2) {
            boolean chooseA1 = Chromosome.randomBoolean();
            boolean chooseA2 = Chromosome.randomBoolean();

            //uses randomBoolean to choose one of the two alleles each parent passes on
            if (chooseA1) {
                childGenes.set(i, parent1.getAllele(i));
            }
            else {
                childGenes.set(i, parent1.getAllele(i + 1));
            }
            if (chooseA2) {
                childGenes.set(i + 1, parent2.getAllele(i));
            }
            else {
                childGenes.set(i + 1, parent2.getAllele(i + 1));
            }
        }
        return new Chromosome(getGeneCount(), childGenes);
    }


    private void set(int spot, boolean allele) {
        chromo.set(spot, allele);
    }

    //returns a specific allele (true/false = dominant/recessive for that gene)
    private boolean getAllele(int spot) {
        return chromo.get(spot);
    }

    //returns the number of genes in the chromosome
    private static int getGeneCount() {
        return gc;
    }

    //customizes how each allele is represented; first letter in each
    //string should represent the dominant trait
//    public ArrayList<String> addName(String[] names) {
//        hasName = true;
//        if (names.length < genecount) {
//            ArrayList<String> list = new ArrayList<>();
//            for (int i = 0; i < genecount; i++) {
//                list.add(i, names[i].substring(0,1));
//            }
//            return list;
//        }
//        return new ArrayList<String>();
//    }

    //prints the allele pairs of the chromosome;
    //dominant allele is capitalized and recessive
    //is lowercase
    public String toString() {
        String printer = "";
        int j = 0;
        if (hasName) {
            for (int i = 0; i < genecount * 2; i++) {
                if (getAllele(i)) {
                    char c = alleleNames[i].charAt(0);
                    String character = c + "";
                    printer += character.toUpperCase();

                }
                else {
                    char c = alleleNames[i].charAt(0);
                    String character = c + "";
                    printer += character.toLowerCase();
                }
            }
        }

        else {
            for (int i = 0; i < genecount * 2; i++) {
                if (getAllele(i)) {                 //true = dominant
                    char c = (char) (65 + j);
                    if (i % 2 == 1) {
                        j++;
                    }
                    printer += c;
                } else {
                    char c = (char) (97 + j);
                    if (i % 2 == 1) {
                        j++;
                    }
                    printer += c;
                }
                if (i % 2 == 1) {
                    printer += ", ";
                }
            }
        }
        return "[" + printer.substring(0, printer.length() - 2) + "]";
    }
}
