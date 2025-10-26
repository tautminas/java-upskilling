import java.util.*;

public class PirateGame extends Game<Pirate> {
    private static List<List<String>> levelMap = List.of(
            List.of("Nassau", "Tortuga"),
            List.of("Kingston", "Havana"),
            List.of("Port Royal", "Maracaibo")
    );

    public PirateGame() {
        super("Pirate Invasion");
    }

    @Override
    public Pirate createNewPlayer(String name) {
        return new Pirate(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        Map<Character, GameAction> actions = new LinkedHashMap<>();
        Pirate pirate = players.get(playerIndex);

        actions.put('V', new GameAction('V', "Visit a town", p -> {
            int level = pirate.getLevel() - 1;
            List<String> towns = levelMap.get(level % levelMap.size());
            String town = towns.get(new Random().nextInt(towns.size()));
            pirate.visitTown(town);
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
