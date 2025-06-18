import java.util.ArrayList;

    /*
     1. Abstract class challenge
     In this challenge, you need to build an application that can be a store
     front for any imaginable item for sale.
     Instead of the Main class we usually create, create a Store class with
     a main method.
     The Store class should:
     • manage a list of products for sale, including displaying the product
     details.
     • manage an order, which can just be a list of OrderItem objects.
     • have methods to add an item to the order, and print the ordered
     items, so it looks like a sales receipt.

     Also create a ProductForSale class that should have at least three fields: a
     type, price, and a description. This class should also have methods to:
     • getSalesPrice, a concrete method, which takes a quantity, and returns
     the quantity times the price.
     • printPricedItem, a concrete method, which takes a quantity, and should
     print an itemized line item for an order, with quantity and line-item
     price.
     • showDetails, an abstract method, which represents what might be
     displayed on a product page. Product type, description, price, and so
     on.
     Also create an OrderItem type, that has at a minimum 2 fields: quantity
     and a Product for Sale. You should also create two or three classes that
     extend the ProductForSale class, that will be products in your store.

     A possible output:
     ---------------------------------------------
     This desktop is a modern computer
     The price of the piece is 700.0 euro.
     Desktop Computer
     ---------------------------------------------
     This laptop is a modern computer
     The price of the piece is 900.0 euro.
     Laptop
     ---------------------------------------------
     This desk was manufactured in Estonia
     The price of the piece is 100.0 euro.
     Computer Desk
     ---------------------------------------------
     This chair was manufactured in Estonia
     The price of the piece is 200.0 euro.
     Reading Chair

     Order 1
     2 items at 900.0 euro each (type: laptop , description: Laptop)
     1 items at 700 euro each (type: desktop, description: Desktop Computer)
     Total sales: 2500.0 euro.

     Order 2
     5 items at 200.0 euro each (type: chair, description: Reading Chair)
     1 items at 700 euro each (type: desktop, description: Desktop Computer)
     1 items at 100.0 euro each (type: desk, description: Computer Desk)
     Total sales: 1800.0 euro.
    */

public class Store {
    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();
    private static ArrayList<OrderItem> order = new ArrayList<>();

    public static void main(String[] args) {
        storeProducts.add(new Desktop());
        storeProducts.add(new Laptop());
        storeProducts.add(new Desk());
        storeProducts.add(new Chair());

        System.out.println("---------------------------------------------");
        for (ProductForSale product : storeProducts) {
            product.showDetails();
            System.out.println("---------------------------------------------");
        }

        // Order 1
        System.out.println("\nOrder 1");
        order.clear();
        order.add(new OrderItem(new Laptop(), 2));
        order.add(new OrderItem(new Desktop(), 1));
        printOrder();

        // Order 2
        System.out.println("\nOrder 2");
        order.clear();
        order.add(new OrderItem(new Chair(), 5));
        order.add(new OrderItem(new Desktop(), 1));
        order.add(new OrderItem(new Desk(), 1));
        printOrder();
    }

    private static void printOrder() {
        double total = 0;
        for (OrderItem item : order) {
            item.printItem();
            total += item.getTotalPrice();
        }
        System.out.println("Total sales: " + total + " euro.");
    }
}
