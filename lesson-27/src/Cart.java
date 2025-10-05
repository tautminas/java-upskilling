import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final int id;
    private final LocalDate date;
    private final String type; // "physical" or "virtual"
    private final Map<InventoryItem, Integer> items = new HashMap<>();

    public Cart(int id, String type) {
        this.id = id;
        this.type = type;
        this.date = LocalDate.now();
    }

    public void addItem(InventoryItem item, int qty) {
        if (item.reserveItem(qty)) {
            items.merge(item, qty, Integer::sum);
        } else {
            System.out.println("Not enough stock for " + item.getProduct().getName());
        }
    }

    public void removeItem(InventoryItem item, int qty) {
        Integer current = items.get(item);
        if (current != null && current >= qty) {
            items.put(item, current - qty);
            item.releaseItem(qty);
        }
    }

    public void printSalesSlip() {
        System.out.println("Sales Slip for Cart " + id);
        double total = 0;
        for (var entry : items.entrySet()) {
            InventoryItem item = entry.getKey();
            int qty = entry.getValue();
            double line = qty * item.getProduct().getSku().length(); // placeholder price
            System.out.println("  " + item.getProduct().getName() + " x " + qty);
            total += line;
        }
        System.out.println("Total: $" + total);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }
}
