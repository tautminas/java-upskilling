import Cars.Car;
import Cars.FuelPoweredCar;
import Cars.ElectricCar;
import Cars.HybridCar;

public class Main {

    /*
     1. Cars
     Create a base class, Car, with one field, description, and three
     methods, startEngine(), drive(), and runEngine().
     The first two methods should be declared as public.
     The method runEngine, however, is protected, and it will only get
     called from the drive method in Car.
     Create three types of subclasses or three types of cars that you
     might find on the road.
     You have the FuelPoweredCar, the ElectricCar, and the HybridCar.

     You can imagine that these three subclasses might have different ways to
     start their engine or drive, depending on their engine type.
     Each of these classes might also have different fields that might be used in
     those methods. Add a couple of appropriate fields to each subclass.
     Create this class structure in Java and override methods appropriately.
     Write code in a Main class and main method that creates an instance of
     each of these classes and that executes different behavior for each.
     Create an array of these objects and loop through the array executing all
     parent class methods. At least one method should print the type of the
     runtime object.
    */

    public static void main(String[] args) {
        Car[] cars = {
                new FuelPoweredCar("Ford Fiesta ", 50),
                new ElectricCar("BMW i4", 85),
                new HybridCar("Toyota Prius", 30, 60)
        };

        for (Car car : cars) {
            System.out.println("\n--- " + car.getClass().getSimpleName() + " ---");
            car.startEngine();
            car.drive();
        }
    }
}
