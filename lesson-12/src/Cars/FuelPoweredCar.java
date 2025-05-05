package Cars;

public class FuelPoweredCar extends Car {
    private double fuelLevel;

    public FuelPoweredCar(String description, double fuelLevel) {
        super(description);
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void startEngine() {
        System.out.println("Igniting fuel engine... Fuel level: " + fuelLevel + " liters");
    }

    @Override
    protected void runEngine() {
        System.out.println("Fuel-powered engine running smoothly.");
    }
}
