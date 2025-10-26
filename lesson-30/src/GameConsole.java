import java.util.*;

public class GameConsole<T extends Game<? extends Player>> {
    private T game;
    private static Scanner scanner = new Scanner(System.in);

    public GameConsole(T game) {
        this.game = game;
    }

    public int addPlayer() {
        System.out.print("Enter your player name: ");
        String name = scanner.nextLine();
        return game.addPlayer(name);
    }

    public void playGame(int playerIndex) {
        boolean keepPlaying = true;
        while (keepPlaying) {
            Map<Character, GameAction> actions = game.getGameActions(playerIndex);

            System.out.println("\n=== " + game.getGameName() + " Menu ===");
            for (GameAction ga : actions.values()) {
                System.out.printf("[%c] %s%n", ga.key(), ga.prompt());
            }

            System.out.print("Choose an option: ");
            String input = scanner.nextLine().toUpperCase();
            if (input.isEmpty()) continue;

            GameAction action = actions.get(input.charAt(0));
            if (action != null) {
                keepPlaying = game.executeGameAction(playerIndex, action);
            } else {
                System.out.println("Invalid option!");
            }
        }
    }
}
