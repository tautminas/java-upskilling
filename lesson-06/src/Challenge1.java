import java.util.Scanner;

public class Challenge1 {

    /*
     1. Invalid numbers
     In this challenge, you'll read 5 valid numbers from the console entered by the user
     and print the sum of those five numbers.
     You need to check that the numbers entered are valid integers. If they are not, print
     out the message "Invalid number" to the console, but continue looping until you do
     have 5 valid numbers.
     Before the user enters each number, prompt them with the message, "Enter
     number #x:", where x represents the count 1, 2, 3, etc.
     As an example, the first message would look something like, "Enter number #1:",
     the next, "Enter number #2:", and so on.
    */

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;

        while (count < 5) {
            System.out.print("Enter number #" + (count + 1) + ": ");
            try {
                sum += Integer.parseInt(scanner.nextLine());
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Sum of valid numbers: " + sum);
    }
}