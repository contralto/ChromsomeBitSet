import java.util.BitSet;
import java.lang.Math;


public class Chromosome {
    private BitSet chromo;
    public Chromosome() {
        chromo = new BitSet(2);
    }

    public Chromosome(boolean isDominant1, boolean isDominant2) {
        chromo = new BitSet(2);
        chromo.set(0, isDominant1);
        chromo.set(1, isDominant2);
    }

    public Chromosome(int numgenes) {
        chromo = new BitSet(numgenes * 2);
    }

    public static boolean randomBoolean() {
        return Math.random() < 0.5;
    }

    public static Chromosome generate() {
        return new Chromosome (randomBoolean(), randomBoolean());
    }

    public static Chromosome cross(Chromosome parent1, Chromosome parent2) {
        Chromosome child = new Chromosome();
        boolean chooseA1 = Chromosome.randomBoolean();
        boolean chooseA2 = Chromosome.randomBoolean();
        if (chooseA1) {
            child.set(0, parent1.get(0));
        }
        else {
            child.set(0, parent1.get(1));
        }
        if (chooseA2) {
            child.set(1, parent2.get(0));
        }
        else {
            child.set(1, parent2.get(1));
        }
        return child;
    }

    private void set(int spot, boolean allele) {
        chromo.set(spot, allele);
    }

    private boolean get(int spot) {
        return chromo.get(spot);
    }

    public String toString() {
        return "[" + chromo.get(0) + ", " + chromo.get(1) + "]";
    }
}
