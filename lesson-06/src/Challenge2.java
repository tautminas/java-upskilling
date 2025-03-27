import java.util.Scanner;

public class Challenge2 {

    /*
     2. Minimum and maximum numbers
     Create an endless loop which:
     • Prompts the user to enter a number or any character to quit.
     • Validates if the user-entered data really is a number.
     • If the user-entered data is not a number, quit the loop.
     • Keeps track of the minimum number entered.
     • Keeps track of the maximum number entered.
     If the user has previously entered a set of numbers (or even just one), display the
     minimum and maximum number that the user entered.
    */

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        while (true) {
            System.out.print("Enter a number to track min/max or any other character to exit: ");
            try {
                double number = Double.parseDouble(scanner.nextLine());

                if (number < min) {
                    min = number;
                }
                if (number > max) {
                    max = number;
                }
            } catch (NumberFormatException e) {
                break;
            }
        }

        scanner.close();

        if (min != Double.MAX_VALUE && max != Double.MIN_VALUE) {
            System.out.println("Minimum number entered: " + min);
            System.out.println("Maximum number entered: " + max);
        } else {
            System.out.println("No valid numbers were entered.");
        }
    }
}