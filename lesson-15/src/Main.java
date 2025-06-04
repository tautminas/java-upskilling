import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    /*
     1. A grocery list
     The challenge is to create an interactive console program, with a menu of options as shown here,
     and functionality that we will describe below:
     Available actions:
     0 - to shutdown
     1 - to add item(s) to list (comma delimited list)
     2 - to remove any items (comma delimited list)
     Enter a number for which action you want to do:
     Using the Scanner class, solicit a menu choice, 0, 1, or 2, and process the item accordingly.

     The list will be a grocery list and should be an ArrayList.
     You should use methods on the ArrayList to add items, remove items, check if an item is already
     in the list, and print a sorted list.
     You should print the list, sorted alphabetically, after each operation.
     You shouldn't allow duplicate items in the list.
    */

    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\nAvailable actions:");
            System.out.println("0 - to shutdown");
            System.out.println("1 - to add item(s) to list (comma delimited list)");
            System.out.println("2 - to remove any items (comma delimited list)");
            System.out.print("Enter a number for which action you want to do: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "0":
                    running = false;
                    System.out.println("Shutting down.");
                    break;
                case "1":
                    System.out.print("Enter item(s) to add: ");
                    String addInput = scanner.nextLine();
                    addItems(groceryList, addInput);
                    break;
                case "2":
                    System.out.print("Enter item(s) to remove: ");
                    String removeInput = scanner.nextLine();
                    removeItems(groceryList, removeInput);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            printSortedList(groceryList);
        }

        scanner.close();
    }

    private static void addItems(ArrayList<String> list, String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim().toLowerCase();
            if (!trimmedItem.isEmpty() && !list.contains(trimmedItem)) {
                list.add(trimmedItem);
            }
        }
    }

    private static void removeItems(ArrayList<String> list, String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim().toLowerCase();
            list.remove(trimmedItem);
        }
    }

    private static void printSortedList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("The grocery list is currently empty.");
        } else {
            ArrayList<String> sortedList = new ArrayList<>(list);
            Collections.sort(sortedList);
            System.out.println("Grocery list: " + sortedList);
        }
    }
}
