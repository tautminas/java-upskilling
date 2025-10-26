package bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankCustomer {
    private String name;
    private int customerId;
    private List<BankAccount> accounts = new ArrayList<>();

    private BankCustomer(String name, int customerId, double checkingInitialDeposit, double savingsInitialDeposit) {
        this.name = name;
        this.customerId = customerId;
        accounts.add(new BankAccount(AccountType.CHECKING, checkingInitialDeposit));
        accounts.add(new BankAccount(AccountType.SAVINGS, savingsInitialDeposit));
    }

    public static BankCustomer createCustomer(String name, int customerId, double checkingInitialDeposit, double savingsInitialDeposit) {
        return new BankCustomer(name, customerId, checkingInitialDeposit, savingsInitialDeposit);
    }

    public String getCustomerId() {
        return String.format("%015d", customerId); // 15-digit string
    }

    public List<BankAccount> getAccounts() {
        return new ArrayList<>(accounts);
    }

    public BankAccount getAccount(AccountType type) {
        return accounts.stream()
                .filter(acc -> acc.getAccountType() == type)
                .findFirst()
                .orElse(null);
    }

    public String getName() {
        return name;
    }
}
