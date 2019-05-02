package stuffs;

import java.util.ArrayList;
import java.util.List;

public class GradeableList {
    private List<Gradeable> myList;

    public GradeableList() {

        myList = new ArrayList<>();

    }

    public void addGradeable(String name, double weight, double outOf, double markReceived, double grade) {
        Gradeable gradeable = new Gradeable(name, weight, outOf, markReceived, grade);
        myList.add(gradeable);
    }


    public double calculateFinalExamWeight() {
        double allOtherWeights = 0;
        for (Gradeable g : myList) {
            allOtherWeights += g.getWeight();
        }

//        if (allOtherWeights >= 100) {
//            throw new InvalidWeightException();
//        }
//
        return (100 - allOtherWeights);
    }

    public double calculateGradeBeforeFinal() {
        double currentGrade = 0;
        for (Gradeable g : myList) {
            currentGrade += (g.getGrade() * g.getWeight());
        }

        return currentGrade;
    }

    public void printAllGradeables() {
        System.out.println("");
        for (Gradeable g : myList) {
            System.out.println(g.getName() + ": " + g.getGrade() + "(grade)"+ g.getWeight() + "(weight)");
        }
        System.out.println("");
    }
}
