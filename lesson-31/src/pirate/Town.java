package pirate;

import java.util.*;

public record Town(String name, String island, int level, List<Loot> loot, List<Feature> features, List<Combatant> opponents) {
    public Town {
        Random rnd = new Random();
        List<Loot> allLoot = Arrays.asList(Loot.values());
        List<Feature> allFeatures = Arrays.asList(Feature.values());

        if (loot == null) {
            List<Loot> picks = new ArrayList<>();
            Collections.shuffle(allLoot, rnd);
            int count = 1 + rnd.nextInt(Math.max(1, allLoot.size()));
            for (int i = 0; i < count; i++) picks.add(allLoot.get(i));
            loot = List.copyOf(picks);
        }

        if (features == null) {
            List<Feature> picks = new ArrayList<>();
            Collections.shuffle(allFeatures, rnd);
            int count = 1 + rnd.nextInt(Math.max(1, allFeatures.size()));
            for (int i = 0; i < count; i++) picks.add(allFeatures.get(i));
            features = List.copyOf(picks);
        }

        if (opponents == null) {
            List<Combatant> foes = new ArrayList<>();
            int count = 1 + rnd.nextInt(2);
            for (int i = 0; i < count; i++) {
                if (rnd.nextBoolean()) {
                    Islander isl = new Islander(name + " Islander#" + (i+1));
                    foes.add(isl);
                } else {
                    Soldier sol = new Soldier(name + " Soldier#" + (i+1));
                    foes.add(sol);
                }
            }
            opponents = List.copyOf(foes);
        }
    }

    public Town(String name, String island, int level) {
        this(name, island, level, null, null, null);
    }
}
