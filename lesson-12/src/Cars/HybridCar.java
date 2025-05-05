package Cars;

public class HybridCar extends Car {
    private double fuelLevel;
    private int batteryPercentage;

    public HybridCar(String description, double fuelLevel, int batteryPercentage) {
        super(description);
        this.fuelLevel = fuelLevel;
        this.batteryPercentage = batteryPercentage;
    }

    @Override
    public void startEngine() {
        System.out.println("Hybrid system starting... Fuel: " + fuelLevel + "L, Battery: " + batteryPercentage + "%");
    }

    @Override
    protected void runEngine() {
        System.out.println("Hybrid engine balancing fuel and electric power.");
    }
}
