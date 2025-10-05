public class InventoryItem {
    private final Product product;
    private int qtyTotal;
    private int qtyReserved;
    private final int qtyReorder;
    private final int qtyLow;
    private double salesPrice;

    public InventoryItem(Product product, int qtyTotal, int qtyReorder, int qtyLow, double salesPrice) {
        this.product = product;
        this.qtyTotal = qtyTotal;
        this.qtyReorder = qtyReorder;
        this.qtyLow = qtyLow;
        this.salesPrice = salesPrice;
        this.qtyReserved = 0;
    }

    public Product getProduct() {
        return product;
    }

    public boolean reserveItem(int qty) {
        if (qty <= (qtyTotal - qtyReserved)) {
            qtyReserved += qty;
            return true;
        }
        return false;
    }

    public void releaseItem(int qty) {
        qtyReserved = Math.max(0, qtyReserved - qty);
    }

    public void sellItem(int qty) {
        if (qty <= qtyReserved) {
            qtyTotal -= qty;
            qtyReserved -= qty;
            checkReorder();
        }
    }

    private void checkReorder() {
        if (qtyTotal <= qtyLow) {
            placeInventoryOrder();
        }
    }

    public void placeInventoryOrder() {
        System.out.println("Reordering " + qtyReorder + " units of " + product.getName());
        qtyTotal += qtyReorder;
    }

    @Override
    public String toString() {
        return product.getName() + " total=" + qtyTotal + " reserved=" + qtyReserved;
    }
}
