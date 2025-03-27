import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // There are four ways in Java to read from the console:
        // 1. System.in - Low-level, hard to use.
        // 2. System.console - Doesn't work in most IDEs.
        // 3. Command Line Arguments - For single-use inputs only.
        // 4. Scanner - Best for interactive applications. Easy to use and flexible.
        // Example:
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter a number: ");
         int num = scanner.nextInt();
         System.out.println("You entered: " + num);

        // ===================================================

        // The try-catch block is used to handle exceptions in Java:
         try {
             int result = 10 / 0;
         } catch (ArithmeticException e) {
             System.out.println("Cannot divide by zero.");
         }

        // ===================================================

        System.out.println("To test a specific challenge, uncomment the relevant section in the Main.java file.");
        //System.out.println("Challenge 1:");
        //Challenge1.run();
        //System.out.println("Challenge 2:");
        //Challenge2.run();
        //System.out.println("Challenge 3:");
        //Challenge3.run();
        //System.out.println("Challenge 4:");
        //Challenge4.run();

    }
}