import java.util.*;

import pirate.*;

public class PirateGame extends Game<Pirate> {
    private static List<List<Town>> levelMap;

    static {
        levelMap = List.of(
                List.of(new Town("Nassau","Caribbean",1), new Town("Tortuga","Caribbean",1)),
                List.of(new Town("Kingston","Caribbean",2), new Town("Havana","Caribbean",2)),
                List.of(new Town("Port Royal","Caribbean",3), new Town("Maracaibo","Caribbean",3))
        );
    }

    public PirateGame() {
        super("Pirate Invasion");
    }

    @Override
    public Pirate createNewPlayer(String name) {
        return new Pirate(name);
    }

    private Town pickTownForLevel(int level) {
        List<Town> towns = levelMap.get(level % levelMap.size());
        return towns.get(new Random().nextInt(towns.size()));
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        Map<Character, GameAction> actions = new LinkedHashMap<>();
        Pirate pirate = players.get(playerIndex);

        actions.put('V', new GameAction('V', "Visit a town", p -> {

            Object cur = pirate.getGameData().get("currentTown");
            Object remaining = pirate.getGameData().get("remainingLoot");
            if (cur != null && remaining instanceof List && !((List<?>)remaining).isEmpty()) {
                System.out.println("You must find all loot in the current town before visiting a new one.");
                return true;
            }

            int level = pirate.getLevel() - 1;
            Town town = pickTownForLevel(level);
            pirate.visitTown(town.name());

            pirate.getGameData().put("currentTown", town);
            pirate.getGameData().put("remainingLoot", new ArrayList<>(town.loot()));
            System.out.println("Arrived at town: " + town.name() + " on " + town.island() + ". Loot items: " + town.loot().size());
            return true;
        }));

        actions.put('F', new GameAction('F', "Find Loot", p -> {
            Object remaining = pirate.getGameData().get("remainingLoot");
            if (!(remaining instanceof List)) {
                System.out.println("You are not in a town. Visit one first.");
                return true;
            }
            List<Loot> rem = (List<Loot>) remaining;
            if (rem.isEmpty()) {
                System.out.println("No loot left in this town.");
                return true;
            }
            Loot found = rem.remove(new Random().nextInt(rem.size()));
            pirate.addScore(found.getWorth());
            System.out.println("You found: " + found + " worth " + found.getWorth());
            return true;
        }));

        actions.put('E', new GameAction('E', "Experience Town Feature", p -> {
            Object cur = pirate.getGameData().get("currentTown");
            if (!(cur instanceof Town)) {
                System.out.println("You are not in a town. Visit one first.");
                return true;
            }
            Town town = (Town) cur;
            List<Feature> features = town.features();
            if (features.isEmpty()) {
                System.out.println("No features to experience here.");
                return true;
            }
            Feature f = features.get(new Random().nextInt(features.size()));
            pirate.adjustHealth(f.getHealthChange());
            System.out.println("You encountered: " + f + ", health change: " + f.getHealthChange());
            return true;
        }));

        actions.put('U', new GameAction('U', "Use weapon on opponent", p -> {
            Object cur = pirate.getGameData().get("currentTown");
            if (!(cur instanceof Town)) {
                System.out.println("You are not in a town. Visit one first.");
                return true;
            }
            Town town = (Town) cur;
            List<Combatant> opponents = new ArrayList<>(town.opponents());
            if (opponents.isEmpty()) {
                System.out.println("No opponents here.");
                return true;
            }
            Combatant target = opponents.get(new Random().nextInt(opponents.size()));
            pirate.useWeapon(target);

            Random rnd = new Random();
            Combatant retaliator = opponents.get(rnd.nextInt(opponents.size()));
            retaliator.useWeapon(pirate);
            return true;
        }));

        actions.put('L', new GameAction('L', "Level up", p -> {
            pirate.levelUp();
            return true;
        }));

        actions.put('W', new GameAction('W', "Change weapon", p -> {
            Weapon[] weapons = Weapon.values();
            Weapon newWeapon = weapons[new Random().nextInt(weapons.length)];
            if (pirate.getLevel() >= newWeapon.getMinLevel()) {
                pirate.setCurrentWeapon(newWeapon);
                System.out.println(pirate.name() + " equipped " + newWeapon);
            } else {
                System.out.println("Level too low to use " + newWeapon);
            }
            return true;
        }));

        actions.put('P', new GameAction('P', "Print player info", this::printPlayer));
        actions.put('Q', new GameAction('Q', "Quit game", this::quitGame));

        return actions;
    }
}
