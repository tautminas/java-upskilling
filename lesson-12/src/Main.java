import Cars.Car;
import Cars.FuelPoweredCar;
import Cars.ElectricCar;
import Cars.HybridCar;

public class Main {
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
