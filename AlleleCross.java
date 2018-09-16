import java.lang.Math;
import java.util.BitSet;

public class AlleleCross {
    private Chromosome parent1, parent2;
    private boolean chooseA1, chooseA2;
    public AlleleCross(Chromosome p1, Chromosome p2) {
        parent1 = p1;
        parent2 = p2;
    }

    public Chromosome cross() {
        Chromosome child = new Chromosome();
        chooseA1 = (int)(Math.random() * 2) < 1;
        chooseA2 = (int)(Math.random() * 2) < 1;
        if (chooseA1) {
            child.set(0, parent1.get(0));
        }
        else {
            child.set(0, parent1.get(1));
        }
        if (chooseA2) {
            child.set(1, parent2.get(1));
        }
        else {
            child.set(1, parent2.get(0));
        }
        return child;
    }
}
