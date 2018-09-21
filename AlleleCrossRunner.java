
public class AlleleCrossRunner {
    public static void main(String[] args) {
        Chromosome parent1 = Chromosome.generate();
        Chromosome parent2 = Chromosome.generate();

        Chromosome child = Chromosome.cross(parent1, parent2);

        System.out.println(parent1.toString() + " " + parent2.toString());
        System.out.println(child.toString());
    }
}
