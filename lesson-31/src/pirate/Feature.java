package pirate;

public enum Feature {
    ALLIGATOR(-8),
    FRESHWATER_SPRING(+6),
    PINEAPPLE(+2),
    QUICKSAND(-4),
    HEALING_HERB(+3);

    private final int healthChange;

    Feature(int healthChange) {
        this.healthChange = healthChange;
    }

    public int getHealthChange() {
        return healthChange;
    }
}
