public class OrderItem {
    private int quantity;
    private ProductForSale product;

    public OrderItem(ProductForSale product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getSalesPrice(quantity);
    }

    public void printItem() {
        product.printPricedItem(quantity);
    }
}
