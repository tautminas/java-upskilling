package pirate;

import java.util.Map;

public final class Soldier extends Combatant {
    public Soldier(String name) {
        super(name);
        this.health = 15;
    }

    public Soldier(String name, Map<String,Object> initialData) {
        super(name, initialData);
        this.health = 15;
    }

    @Override
    public String name() {
        return super.name();
    }
}
