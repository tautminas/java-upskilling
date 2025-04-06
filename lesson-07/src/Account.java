public class Account {

    /*
     1. Bank account
     Create a class Account for a bank account.
     Create private fields for account characteristics like:
     • account number.
     • account balance.
     • customer name.
     • email.
     • phone number.

     Create getters and setters for each field.
     Create two additional methods:
     • one for depositing funds into the account.
     • one for withdrawing funds from the account.

     A customer should not be allowed to withdraw funds if that withdrawal takes their
     balance negative.
     From your Main class with the usual main method create an instance of an Account
     class and then test your methods for withdrawing and depositing funds.
     Print information to the console that confirms what the balance is after the
     methods are called.

     Create an encapsulated class Account, where all fields are private. Set up getter and
     setter methods for all your fields.
     The class should have two behavioral methods. One for depositing funds, the other
     for withdrawing funds.
     In addition to this class, you need a Main class with a main method that creates at
     least one instance of the bank account class and simulates depositing and
     withdrawing money from the account.
    */

    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public Account(String accountNumber, double balance, String customerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance is $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Cannot withdraw $" + amount);
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". New balance is $" + balance);
        }
    }
}
