public class Main {
    public static void main(String[] args) {

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

    }
}
