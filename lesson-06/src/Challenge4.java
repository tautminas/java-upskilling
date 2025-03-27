import java.util.Scanner;

public class Challenge4 {

    /*
     4. A text-based adventure game
     Write first two levels of menu screens of a text-based adventure game like the
     Oregon Trail. The first menu level must have at least 5 different choices and the
     second menu level may just have some arbitrary texts. A user must enter a number
     to proceed to the second menu level or exit the game and ESC (or any other key of
     your choice) to return to the first menu level. The game must ignore any entered
     symbols, except numbers and ESC key. The game must have a title, which is shown
     above the menus.
     An example of a classic text-based adventure game:
     https://www.visitoregon.com/the-oregon-trail-game-online/
     https://en.wikipedia.org/wiki/The_Oregon_Trail_(series)
    */

    private static final String TITLE = "=== Java Learning Adventure ===";
    private static final String ESC_TEXT = "esc";

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMainMenu();
            String choice = scanner.nextLine().trim();

            if (choice.equals("5")) {
                System.out.println("Exiting the adventure...");
                break;
            }

            switch (choice) {
                case "1":
                    showSubMenu("You dive into the world of Object-Oriented Programming...");
                    break;
                case "2":
                    showSubMenu("You start mastering Java Collections and data structures...");
                    break;
                case "3":
                    showSubMenu("You explore Java Streams and functional programming...");
                    break;
                case "4":
                    showSubMenu("You take on multi-threading and concurrency challenges...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
    }

    private static void showMainMenu() {
        System.out.println("\n" + TITLE);
        System.out.println("1. Learn Object-Oriented Programming");
        System.out.println("2. Study Collections and Data Structures");
        System.out.println("3. Understand Streams and Functional Programming");
        System.out.println("4. Explore Multi-threading and Concurrency");
        System.out.println("5. Exit the adventure");
        System.out.print("Choose an option: ");
    }

    private static void showSubMenu(String message) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + message);
            System.out.println("Type 'esc' to return to the main menu.");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase(ESC_TEXT)) {
                break;
            } else {
                System.out.println("Invalid input. Type 'esc' to return to the main menu.");
            }
        }
    }
}