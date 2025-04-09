package carpetcostcalculator;

public class Main {

    /*
     1. Carpet cost calculator
     The Carpet Company has asked you to write an application that calculates the price
     of carpeting for rectangular rooms. To calculate the price, you multiply the area of
     the floor (width times length) by the price per square meter of carpet. For example,
     the area of the floor that is 12 meters long and 10 meters wide is 120 square meters.
     To cover the floor with a carpet that costs 8€ per square meter would cost 960€.

     Write a class with the name Carpet. The class needs two instance fields with names
     width and length of type double, and one static field with name squareMeterCost, which
     would contain the cost of one square meter of the carpet.
     The class needs to have one constructor with parameters width and length of type
     double, and it needs to initialize the fields. In case the width or length parameters are
     less than 0 it needs to set the value to 0.
     Write the instance method named getArea without any parameters, which would return
     the calculated area (width * length).
     Write the instance method named getTotalCost without any parameters, which would
     return the calculated total cost to cover the floor with a carpet.
     Create several instances of the Carpet class in your main method with different sizes and
     print their costs.
    */

    public static void main(String[] args) {
        Carpet.squareMeterCost = 8.0;

        Carpet room1 = new Carpet(12, 10);
        Carpet room2 = new Carpet(5.5, 4.2);
        Carpet room3 = new Carpet(3.5, 6);
        Carpet room4 = new Carpet(-3, 4);

        System.out.println("Room 1 total cost: " + room1.getTotalCost() + "€");
        System.out.println("Room 2 total cost: " + room2.getTotalCost() + "€");
        System.out.println("Room 3 total cost: " + room3.getTotalCost() + "€");
        System.out.println("Room 4 total cost (invalid width): " + room4.getTotalCost() + "€");
    }
}
