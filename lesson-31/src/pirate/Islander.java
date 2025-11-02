package pirate;

import java.util.Map;

public final class Islander extends Combatant {
    public Islander(String name) {
        super(name);
    }

    public Islander(String name, Map<String,Object> initialData) {
        super(name, initialData);
    }

    @Override
    public String name() {
        return super.name();
    }
}
