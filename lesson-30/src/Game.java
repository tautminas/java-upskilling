import java.util.*;

public abstract class Game<T extends Player> {
    protected String gameName;
    protected List<T> players = new ArrayList<>();
    protected Map<Character, GameAction> standardActions = new LinkedHashMap<>();

    public Game(String name) {
        this.gameName = name;
    }

    public abstract T createNewPlayer(String name);
    public abstract Map<Character, GameAction> getGameActions(int playerIndex);

    public int addPlayer(String name) {
        T player = createNewPlayer(name);
        players.add(player);
        System.out.println("Welcome, " + player.name() + "!");
        return players.size() - 1;
    }

    public boolean executeGameAction(int player, GameAction action) {
        return action.action().test(player);
    }

    public boolean printPlayer(int playerIndex) {
        System.out.println("Player info: " + players.get(playerIndex).name());
        return true;
    }

    public boolean quitGame(int playerIndex) {
        System.out.println("Goodbye, " + players.get(playerIndex).name() + "!");
        return false;
    }

    public String getGameName() {
        return gameName;
    }
}
