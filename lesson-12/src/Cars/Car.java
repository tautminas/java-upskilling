package Cars;

public class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void startEngine() {
        System.out.println("Starting engine for: " + description);
    }

    public void drive() {
        runEngine();
        System.out.println("Driving " + description);
    }

    protected void runEngine() {
        System.out.println("Running generic car engine...");
    }
}
