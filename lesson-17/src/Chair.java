public class Chair extends ProductForSale {
    public Chair() {
        super("chair", 200.0, "Reading Chair");
    }

    @Override
    public void showDetails() {
        System.out.println("This chair was manufactured in Estonia");
        System.out.println("The price of the piece is " + price + " euro.");
        System.out.println(description);
    }
}
