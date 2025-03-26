import java.util.Scanner;

public class Challenge1 {

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