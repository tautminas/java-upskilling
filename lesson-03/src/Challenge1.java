public class Challenge1 {

    /*
     1. An exam grade
     Write a method, which takes in an int variable with an exam score and returns a
     grade from “A” to “F” according to a European university grade system.
    */

    public static void run(int score) {
        char grade = getGrade(score);
        System.out.println("The grade for score " + score + " is: " + grade);
    }

    private static char getGrade(int score) {
        if (score >= 90 && score <= 100) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else if (score >= 50) {
            return 'E';
        } else {
            return 'F';
        }
    }
}
