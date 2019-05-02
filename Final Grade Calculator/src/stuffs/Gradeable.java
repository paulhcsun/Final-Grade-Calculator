package stuffs;

public class Gradeable {

    private String name;
    private double totalMarks;
    private double receivedMarks;
    private double grade;
    private double weight;

    public Gradeable(String name, double weight, double totalMarks, double receivedMarks, double grade) {
        this.name = name;
        this.weight = weight;
        this.totalMarks = totalMarks;
        this.receivedMarks = receivedMarks;
        this.grade = grade;

    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getGrade() {
        return grade;
    }
}
