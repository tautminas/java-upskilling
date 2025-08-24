package innerclasses;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private Burger burger;

    public Meal(String burgerName, double burgerPrice) {
        this.burger = new Burger(burgerName, burgerPrice);
    }

    public void addToppings(String... toppingNames) {
        for (String toppingName : toppingNames) {
            burger.addTopping(toppingName);
        }
    }

    public void printMeal() {
        System.out.println("Meal includes: ");
        System.out.println(burger);
        System.out.printf("Total price: $%.2f%n", burger.getTotalPrice());
    }

    private class Burger extends Item {
        private List<Item> toppings;

        public Burger(String name, double price) {
            super(name, "Burger", price);
            this.toppings = new ArrayList<>();
        }

        public void addTopping(String toppingName) {
            double price = getToppingPrice(toppingName);
            toppings.add(new Item(toppingName, "Topping", price));
        }

        private double getToppingPrice(String toppingName) {
            switch (toppingName.toLowerCase()) {
                case "lettuce":
                case "tomato":
                    return 0.00;
                case "cheese":
                    return 0.50;
                case "bacon":
                    return 1.00;
                default:
                    return 0.25;
            }
        }

        public double getTotalPrice() {
            double total = getPrice(); // burger base price
            for (Item topping : toppings) {
                total += topping.getPrice();
            }
            return total;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(super.toString());
            if (!toppings.isEmpty()) {
                sb.append("\n  Toppings:");
                for (Item topping : toppings) {
                    sb.append("\n   - ").append(topping);
                }
            }
            return sb.toString();
        }
    }
}
