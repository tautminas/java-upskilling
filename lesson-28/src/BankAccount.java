public final class BankAccount {
    private final String type;
    private double balance;

    public BankAccount(String type, double balance) {
        this.type = type;
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    @Override
    public String toString() {
        return type + " Account, balance: $" + balance;
    }
}
