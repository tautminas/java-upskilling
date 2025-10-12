import java.util.Collections;
import java.util.List;

public sealed class BankCustomer permits PremiumCustomer {
    private final String name;
    private final String id;
    private final List<BankAccount> accounts;

    public BankCustomer(String name, String id, List<BankAccount> accounts) {
        this.name = name;
        this.id = id;
        this.accounts = Collections.unmodifiableList(accounts);
    }

    public final String getName() {
        return name;
    }

    public final String getId() {
        return id;
    }

    public final List<BankAccount> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Customer: " + name + " (ID: " + id + ")\nAccounts: " + accounts;
    }
}
