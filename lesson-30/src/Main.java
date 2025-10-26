public class Main {
    public static void main(String[] args) {
        PirateGame game = new PirateGame();
        GameConsole<PirateGame> console = new GameConsole<>(game);
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
    }
}
