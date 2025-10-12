import java.util.List;

    /*
     1. A bank account

     Create a BankAccount class, which have a type, indicating the type of account, like
     Checking or Savings or some other type.
     It should have a balance, the initial money amount in the account.
     You should also create a BankCustomer class that has a customer name, a customer id,
     and a List of accounts.
     You should use some of the techniques we discussed in this chapter to design the classes.
     Create a couple of instances of bank customers, confirming that you can't change a
     customer's data at all, after it's initialized.
     Create a subclass of the bank customer and confirm that the subclass can't tamper with
     the customer's data as well.
    */

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Checking", 1000);
        BankAccount acc2 = new BankAccount("Savings", 3000);

        BankCustomer customer = new BankCustomer("Alice", "C001", List.of(acc1, acc2));
        System.out.println(customer);

        // Trying to modify data
        // customer.getAccounts().add(new BankAccount("Investment", 5000)); // throws exception

        PremiumCustomer premium = new PremiumCustomer("Bob", "P001", List.of(new BankAccount("Savings", 5000)));
        System.out.println(premium);
    }
}
