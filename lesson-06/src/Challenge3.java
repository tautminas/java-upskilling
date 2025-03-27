import java.util.Scanner;

public class Challenge3 {

    /*
     3. Calculator
     Write a method, which would ask a user to input numbers and when the user enters
     something that is not an int then it needs to print a message in the format
     "SUM = XX AVG = YY", where XX represents the sum of all entered numbers of type int and
     YY represents the calculated average of all numbers of type long.
     The method should not have any parameters and should not return anything (void),
     and it needs to keep reading int numbers from the keyboard until cancelled.
    */

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        long count = 0;

        while (true) {
            System.out.print("Enter a number to calculate sum and average or any other character to exit: ");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                sum += number;
                count++;
            } catch (NumberFormatException e) {
                break;
            }
        }

        scanner.close();
        printResult(sum, count);
    }

    private static void printResult(int sum, long count) {
        long average = (count > 0) ? Math.round((double) sum / count) : 0;
        System.out.println("SUM = " + sum + " AVG = " + average);
    }
}