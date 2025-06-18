public class Desk extends ProductForSale {
    public Desk() {
        super("desk", 100.0, "Computer Desk");
    }

    @Override
    public void showDetails() {
        System.out.println("This desk was manufactured in Estonia");
        System.out.println("The price of the piece is " + price + " euro.");
        System.out.println(description);
    }
}
