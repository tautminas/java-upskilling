package bank;

import transactions.Transaction;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BankAccount {
    private AccountType accountType;
    private double balance;
    private Map<Long, Transaction> transactions = new HashMap<>();

    public BankAccount(AccountType accountType, double initialDeposit) {
        this.accountType = accountType;
        this.balance = initialDeposit;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public Map<Long, Transaction> getTransactions() {
        return Collections.unmodifiableMap(transactions);
    }

    public boolean commitTransaction(int routingNumber, long transactionId, int customerId, double amount) {
        double newBalance = balance + amount;
        if (newBalance < 0) {
            System.out.println("❌ Transaction denied: insufficient funds.");
            return false;
        }
        this.balance = newBalance;
        Transaction transaction = new Transaction(routingNumber, customerId, transactionId, amount);
        transactions.put(transactionId, transaction);
        return true;
    }
}
