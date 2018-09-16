import java.lang.Math;

public class AlleleCrossRunner {
    public static void main(String[] args) {
        boolean pick1 = (int)(Math.random() * 2) < 1;
        boolean pick2 = (int)(Math.random() * 2) < 1;
        boolean pick3 = (int)(Math.random() * 2) < 1;
        boolean pick4 = (int)(Math.random() * 2) < 1;

        Chromosome parent1 = new Chromosome(pick1, pick2);
        Chromosome parent2 = new Chromosome(pick3, pick4);

        AlleleCross test = new AlleleCross(parent1, parent2);
        Chromosome child = test.cross();

        System.out.println(parent1.toString() + " " + parent2.toString());
        System.out.println(child.toString());
    }
}
