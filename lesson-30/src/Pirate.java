import java.util.*;

public class Pirate implements Player {
    private String name;
    private int level = 1;
    private Weapon currentWeapon = Weapon.KNIFE;
    private Set<String> townsVisited = new HashSet<>();

    public Pirate(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
        System.out.println(name + " leveled up to " + level + "!");
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon weapon) {
        this.currentWeapon = weapon;
    }

    public void visitTown(String town) {
        townsVisited.add(town);
        System.out.println(name + " visited " + town + "!");
    }
}
