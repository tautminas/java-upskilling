public class Desktop extends ProductForSale {
    public Desktop() {
        super("desktop", 700.0, "Desktop Computer");
    }

    @Override
    public void showDetails() {
        System.out.println("This desktop is a modern computer");
        System.out.println("The price of the piece is " + price + " euro.");
        System.out.println(description);
    }
}
