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
        challenge4();

    }

    public static void challenge4() {
        File file = new File("./src/data/films.json");

        Scanner scanner;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            return;
        }

        Film film1 = getFilmData(scanner);
        Film film2 = getFilmData(scanner);
        Film film3 = getFilmData(scanner);
        Film film4 = getFilmData(scanner);
        Film film5 = getFilmData(scanner);

        scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("====== Studio Ghibli films ======");
            System.out.println();
            System.out.println("1. " + film1.getTitle());
            System.out.println("2. " + film2.getTitle());
            System.out.println("3. " + film3.getTitle());
            System.out.println("4. " + film4.getTitle());
            System.out.println("5. " + film5.getTitle());
            System.out.println("6. Exit the application");
            System.out.println();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            if (choice == 6) break;

            switch (choice) {
                case 1 -> printFilmDetails(film1);
                case 2 -> printFilmDetails(film2);
                case 3 -> printFilmDetails(film3);
                case 4 -> printFilmDetails(film4);
                case 5 -> printFilmDetails(film5);
                default -> System.out.println("Invalid choice.");
            }

            while (true) {
                scanner = new Scanner(System.in);
                System.out.println("Press Q to return to the main menu.");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("Q")) break;
                System.out.println("Invalid input. Please press Q to go back.");
            }

        }

        scanner.close();
    }

    public static String getFieldValue(Scanner scanner, String field) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.contains('"' + field + '"')) {
                int colonIndex = line.indexOf(':');
                if (colonIndex != -1) {
                    String value = line.substring(colonIndex + 1).trim();
                    return value.replace("\"", "").replace(",", "");
                }
            }
        }
        return null;
    }

    public static Film getFilmData(Scanner scanner) {
        String title = getFieldValue(scanner,"title");
        String description = getFieldValue(scanner,"description");
        String director = getFieldValue(scanner,"director");
        String producer = getFieldValue(scanner,"producer");
        String releaseDate = getFieldValue(scanner,"release_date");
        String runningTime = getFieldValue(scanner,"running_time");
        return new Film(title, director, producer, releaseDate, runningTime, description);
    }

    public static void printFilmDetails(Film film) {
        System.out.println();
        System.out.println("======= FILM DETAILS =======");
        System.out.println("Title        : " + film.getTitle());
        System.out.println("Director     : " + film.getDirector());
        System.out.println("Producer     : " + film.getProducer());
        System.out.println("Release Date : " + film.getReleaseDate());
        System.out.println("Running Time : " + film.getRunningTime());
        System.out.println();
        System.out.println("Description  : " + film.getDescription());
        System.out.println();
    }

}
