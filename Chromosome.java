import java.util.BitSet;


public class Chromosome {
    private BitSet chromo;
    public Chromosome() {
        chromo = new BitSet(2);
    }

    public Chromosome(boolean a1, boolean a2) {
        chromo = new BitSet(2);
        chromo.set(0, a1);
        chromo.set(1, a2);
    }

    public void set(int spot, boolean allele) {
        chromo.set(spot, allele);
    }

    public boolean get(int spot) {
        return chromo.get(spot);
    }

    public String toString() {
        return "[" + chromo.get(0) + ", " + chromo.get(1) + "]";
    }
}
