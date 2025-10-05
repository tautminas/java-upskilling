import java.time.LocalDate;
import java.util.*;

public class Store {
    private final Map<String, InventoryItem> inventory = new HashMap<>();
    private final Map<Integer, Cart> carts = new HashMap<>();
    private final Map<Category, List<InventoryItem>> aisleInventory = new EnumMap<>(Category.class);

    public void addInventoryItem(InventoryItem item) {
        inventory.put(item.getProduct().getSku(), item);
        aisleInventory
                .computeIfAbsent(item.getProduct().getCategory(), c -> new ArrayList<>())
                .add(item);
    }

    public void manageStoreCarts(Cart cart) {
        carts.put(cart.getId(), cart);
    }

    public void checkOutCart(int cartId) {
        Cart cart = carts.remove(cartId);
        if (cart != null) {
            System.out.println("Checking out cart " + cartId);
        }
    }

    public void abandonCarts() {
        LocalDate today = LocalDate.now();
        carts.values().removeIf(cart -> !cart.getDate().equals(today));
    }

    public void listProductsByCategory(Category category) {
        List<InventoryItem> list = aisleInventory.getOrDefault(category, List.of());
        System.out.println("Products in category " + category + ":");
        list.forEach(System.out::println);
    }
}
