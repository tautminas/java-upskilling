package carpetcostcalculator;

public class Carpet {

    private double width;
    private double length;

    public static double squareMeterCost;

    public Carpet(double width, double length) {
        this.width = (width < 0) ? 0 : width;
        this.length = (length < 0) ? 0 : length;
    }

    public double getArea() {
        return width * length;
    }

    public double getTotalCost() {
        return getArea() * squareMeterCost;
    }

    public static void main(String[] args) {
        Carpet.squareMeterCost = 8.0;

        Carpet room1 = new Carpet(12, 10);
        Carpet room2 = new Carpet(5.5, 4.2);
        Carpet room3 = new Carpet(-3, 6);

        System.out.println("Room 1 cost: " + room1.getTotalCost() + "€");
        System.out.println("Room 2 cost: " + room2.getTotalCost() + "€");
        System.out.println("Room 3 cost: " + room3.getTotalCost() + "€");
    }
}
