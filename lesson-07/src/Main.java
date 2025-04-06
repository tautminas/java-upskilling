import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 'static' means the member (field or method) belongs to the class itself,
        // not to individual objects. There is only one copy shared by all instances.

        // If something is not static, it belongs to the object (instance) created
        // from the class. Each object has its own copy of instance fields and methods.

        // ===================================================

        // Classes can be grouped into packages for better organization.
        // If no package is declared, the class belongs to the default package.

        // ===================================================

        // Access modifiers control where a class, method, or field can be accessed from.

        // 'public' means it can be accessed from anywhere.

        // 'protected' means it can be accessed within the same package,
        // and by subclasses (even if they're in a different package).

        // 'private' means it can only be accessed within the same class.

        // These rules apply to fields, methods, and inner classes.
        // Top-level classes can only be 'public' or have no modifier (package-private).
        
        // Challenge 1
        System.out.println("Challenge 1:");
        Account myAccount = new Account("123456789", 500.0, "Jane Doe", "jane@example.com", "555-1234");
        System.out.println("Initial balance: $" + myAccount.getBalance());
        myAccount.deposit(200.0);
        myAccount.withdraw(100.0);
        myAccount.withdraw(700.0);
        System.out.println("Final balance: $" + myAccount.getBalance());

        // Challenge 2
        System.out.println("\nChallenge 2:");
        Calculator calculator = new Calculator();
        calculator.setFirstNumber(5.0);
        calculator.setSecondNumber(4);
        System.out.println("add= " + calculator.getAdditionResult());
        System.out.println("subtract= " + calculator.getSubtractionResult());
        calculator.setFirstNumber(5.25);
        calculator.setSecondNumber(0);
        System.out.println("multiply= " + calculator.getMultiplicationResult());
        System.out.println("divide= " + calculator.getDivisionResult());

        // Challenge 3
        System.out.println("\nChallenge 3:");
        Customer customer1 = new Customer();
        System.out.println(customer1.getName() + " - " + customer1.getCreditLimit() + " - " + customer1.getEmailAddress());

        Customer customer2 = new Customer("Alice", "alice@example.com");
        System.out.println(customer2.getName() + " - " + customer2.getCreditLimit() + " - " + customer2.getEmailAddress());

        Customer customer3 = new Customer("Bob", 3000.0, "bob@example.com");
        System.out.println(customer3.getName() + " - " + customer3.getCreditLimit() + " - " + customer3.getEmailAddress());

        // Challenge 4
        System.out.println("\nChallenge 4:");
        File file = new File("./src/data.json");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }
}
