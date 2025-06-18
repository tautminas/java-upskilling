public class Laptop extends ProductForSale {
    public Laptop() {
        super("laptop", 900.0, "Laptop");
    }

    @Override
    public void showDetails() {
        System.out.println("This laptop is a modern computer");
        System.out.println("The price of the piece is " + price + " euro.");
        System.out.println(description);
    }
}
