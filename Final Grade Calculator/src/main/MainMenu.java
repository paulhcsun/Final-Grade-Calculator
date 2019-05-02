package main;

import stuffs.GradeableList;

import java.util.Scanner;

public class MainMenu {

    Scanner scan;
    GradeableList gl;

    public MainMenu() {
        scan = new Scanner(System.in);
        gl = new GradeableList();

    }

    public void runMainMenu() {
        while (true) {
            System.out.println("Please enter an assignment/exam...");
            String item = scan.nextLine();
            System.out.println("Gradeable is out of...");
            double outOf = Double.parseDouble(scan.nextLine());

            System.out.println("How many marks earned?");
            double markReceived = Double.parseDouble(scan.nextLine());
            System.out.println("Weighting of gradeable...(percentage)");
            double weight = Double.parseDouble(scan.nextLine());
            double grade = calculatePercentage(markReceived, outOf);
            gl.addGradeable(item, weight, outOf, markReceived, grade);
            System.out.println("Would you like to add another item? (y/n)");
            String decision = scan.nextLine();
            if (decision.equals("n")) {
                break;
            }
            printCurrentGradeables();
        }
        System.out.println("What grade do you hope to achieve overall in this course?");
        double courseGrade = Double.parseDouble(scan.nextLine());
        double requiredFinalExamMark = calculateFinalGrade(courseGrade);
        System.out.println("Grade required on your final in order to achieve " + courseGrade + "%" + " is " + requiredFinalExamMark + "%.");

    }

//    private void addGradeable(String item) {
//        while (true) {
//            System.out.println("Gradeable is out of...");
//            double outOf = Double.parseDouble(scan.nextLine());
//
//            System.out.println("How many marks earned?");
//            double markReceived = Double.parseDouble(scan.nextLine());
//            System.out.println("Weighting of gradeable...(percentage)");
//            double weight = Double.parseDouble(scan.nextLine());
//            double grade = calculatePercentage(markReceived, outOf);
//            gl.addGradeable(item, weight, outOf, markReceived, grade);
//            System.out.println("Would you like to add another item? (y/n)");
//            String decision = scan.nextLine();
//            if (decision.equals("n")) {
//                break;
//            }
//            printCurrentGradeables();
//        }
//        System.out.println("What grade do you hope to achieve overall in this course?");
//        double courseGrade = Double.parseDouble(scan.nextLine());
//        double requiredFinalExamMark = calculateFinalGrade(courseGrade);
//        System.out.println("Grade required on your final in order to achieve " + courseGrade + " is " + requiredFinalExamMark + ".");
//    }

    private void printCurrentGradeables() {
        gl.printAllGradeables();
    }

    private double calculatePercentage(double received, double total) {
        return received/total;
    }

    private double calculateFinalGrade(double desiredGrade) {

        double finalExamWeight = gl.calculateFinalExamWeight();
        double gradeBeforeFinal = gl.calculateGradeBeforeFinal();
        double marksNeededFromFinal = desiredGrade - gradeBeforeFinal;
        double requiredFinalGrade = (marksNeededFromFinal/finalExamWeight) * 100;

        return requiredFinalGrade;
    }
}
