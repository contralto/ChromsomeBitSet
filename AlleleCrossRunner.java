
public class AlleleCrossRunner {
    public static void main(String[] args) {
        Chromosome parent1 = new Chromosome(1);
        Chromosome parent2 = new Chromosome(1);

        Chromosome child1 = Chromosome.cross(parent1, parent2);

        Chromosome parent3 = new Chromosome(2);
        Chromosome parent4 = new Chromosome(2);

        Chromosome child2 = Chromosome.cross(parent3, parent4);

        System.out.println("p1: " + parent1.toString() + ", p2: " + parent2.toString());
        System.out.println("c1: " + child1.toString());

        System.out.println("p3: " + parent3.toString() + ", p4: " + parent4.toString());
        System.out.println("c2: " + child2.toString());
    }
}
