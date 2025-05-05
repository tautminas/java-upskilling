package Cars;

public class ElectricCar extends Car {
    private int batteryPercentage;

    public ElectricCar(String description, int batteryPercentage) {
        super(description);
        this.batteryPercentage = batteryPercentage;
    }

    @Override
    public void startEngine() {
        System.out.println("Powering electric motor... Battery at " + batteryPercentage + "%");
    }

    @Override
    protected void runEngine() {
        System.out.println("Electric motor humming quietly.");
    }
}
