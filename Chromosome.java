import java.util.BitSet;
import java.lang.Math;


public class Chromosome {
    private BitSet chromo;
    private int genecount;
    private static int gc;
    public Chromosome() {
        chromo = new BitSet(2);
        genecount = 1;
        gc = 1;
    }

    public Chromosome(int numgenes) {
        chromo = new BitSet(numgenes * 2);
        genecount = numgenes;
        gc = numgenes;
    }

    public Chromosome(boolean isDominant1, boolean isDominant2) {
        chromo = new BitSet(2);
        chromo.set(0, isDominant1);
        chromo.set(1, isDominant2);
        genecount = 1;
        gc = 1;
    }

    public Chromosome(int numgenes, boolean[] ray) {
        chromo = new BitSet(numgenes * 2);
        genecount = numgenes;
        gc = numgenes;
        for (int i = 0; i < numgenes; i += 2) {
            chromo.set(i, ray[i]);          //represents allele 1 of a certain gene
            chromo.set(i + 1, ray[i + 1]);  //represents allele 2 of a certain gene
        }
    }

    private static boolean randomBoolean() {
        return Math.random() < 0.5;
    }

    public static Chromosome generate() {
        return new Chromosome (randomBoolean(), randomBoolean());
    }

    public static Chromosome cross(Chromosome parent1, Chromosome parent2) {
        Chromosome child = new Chromosome(gc);
        for (int i = 0; i < parent1.getGeneCount(); i += 2) {
            boolean chooseA1 = Chromosome.randomBoolean();
            boolean chooseA2 = Chromosome.randomBoolean();
            if (chooseA1) {
                child.set(i, parent1.getAllele(i));
            } else {
                child.set(i, parent1.getAllele(i + 1));
            }
            if (chooseA2) {
                child.set(i + 1, parent2.getAllele(i));
            } else {
                child.set(i + 1, parent2.getAllele(i + 1));
            }
        }
        return child;
    }

    private void set(int spot, boolean allele) {
        chromo.set(spot, allele);
    }

    private boolean getAllele(int spot) {
        return chromo.get(spot);
    }

    private static int getGeneCount() {
        return gc;
    }

    public String toString() {
        String printer = "";
        for (int i = 0; i < genecount * 2; i++) {
            printer += getAllele(i) + ", ";
        }
        return "[" + printer.substring(0, printer.length() - 2) + "]";
    }
}
