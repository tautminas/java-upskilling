package innerclasses;

    /*
     1. Inner classes
     Create in the class Meal another inner class, called Burger. This should be a
     specialized Item, and should also include a list of toppings, also Items.
     Remember Items have a name, type, price, and method toString.
     Allow a user to add toppings using the Meal class, which it should then
     delegate to its burger class.
     Allow toppings to be added with a method that allows for a variable
     number of Strings to be entered, representing the toppings selected.
     Allow toppings to be priced differently, some are free, some have an
     additional cost. Print the toppings out along with the burger information.
    */

public class Main {
    public static void main(String[] args) {
        Meal meal = new Meal("Classic Burger", 5.99);
        meal.addToppings("Lettuce", "Tomato", "Cheese", "Bacon", "Onion");
        meal.printMeal();
    }
}
