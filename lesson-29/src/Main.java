package bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(555123);

        bank.addCustomer("Alice", 500.0, 1000.0);

        BankCustomer customer = bank.getCustomer("000000000000001");

        if (customer != null) {
            bank.doTransaction(customer.getCustomerId(), AccountType.CHECKING, -200.0);
            bank.doTransaction(customer.getCustomerId(), AccountType.SAVINGS, 300.0);

            BankAccount checking = customer.getAccount(AccountType.CHECKING);
            System.out.println("\n🧾 Checking account transactions:");
            checking.getTransactions().values().forEach(System.out::println);

            System.out.println("\n💰 Current Checking Balance: " + checking.getBalance());
        }
    }
}
