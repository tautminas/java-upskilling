package pirate;

import java.util.*;

public final class Pirate extends Combatant {
    public Pirate(String name) {
        super(name);
    }

    public Pirate(String name, Map<String,Object> initialData) {
        super(name, initialData);
    }

    @Override
    public String name() {
        return super.name();
    }

}
