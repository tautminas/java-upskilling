public final class Product {
    private final String sku;
    private final String name;
    private final String manufacturer;
    private final Category category;

    public Product(String sku, String name, String manufacturer, Category category) {
        this.sku = sku;
        this.name = name;
        this.manufacturer = manufacturer;
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, sku);
    }
}
