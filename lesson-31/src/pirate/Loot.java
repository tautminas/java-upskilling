package pirate;

public enum Loot {
    GOLD_COINS(10),
    PEARL_NECKLACE(25),
    SILVER_CUP(8),
    JEWEL(40),
    MAP_FRAGMENT(5);

    private final int worth;

    Loot(int worth) {
        this.worth = worth;
    }

    public int getWorth() {
        return worth;
    }
}
