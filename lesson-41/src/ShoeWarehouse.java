import java.util.*;

public class ShoeWarehouse {

    public static final List<String> PRODUCT_LIST =
            List.of("Sneakers", "Boots", "Sandals", "Heels");

    private final Queue<Order> orders = new LinkedList<>();
    private final int MAX_CAPACITY = 5;

    public synchronized void receiveOrder(Order order) {
        while (orders.size() == MAX_CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        orders.add(order);
        System.out.println("Received order: " + order);
        notifyAll();
    }

    public synchronized Order fulfillOrder() {
        while (orders.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        Order order = orders.poll();
        System.out.println("Fulfilled order: " + order);
        notifyAll();
        return order;
    }
}
