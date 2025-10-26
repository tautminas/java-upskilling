package bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private int routingNumber;
    private long lastTransactionId = 1000;
    private Map<String, BankCustomer> customers = new HashMap<>();

    public Bank(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public BankCustomer getCustomer(String id) {
        return customers.get(id);
    }

    public void addCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit) {
        int customerId = customers.size() + 1;
        BankCustomer customer = BankCustomer.createCustomer(name, customerId, checkingInitialDeposit, savingsInitialDeposit);
        customers.put(customer.getCustomerId(), customer);
        System.out.println("✅ Added new customer: " + name + " (" + customer.getCustomerId() + ")");
    }

    public void doTransaction(String id, AccountType type, double amount) {
        BankCustomer customer = customers.get(id);
        if (customer == null) {
            System.out.println("❌ Customer not found.");
            return;
        }
        BankAccount account = customer.getAccount(type);
        if (account == null) {
            System.out.println("❌ Account not found.");
            return;
        }
        long newTransactionId = ++lastTransactionId;
        boolean success = account.commitTransaction(routingNumber, newTransactionId, Integer.parseInt(id), amount);
        if (success) {
            System.out.println("✅ Transaction successful: " + amount + " to " + type + " account.");
        }
    }
}
