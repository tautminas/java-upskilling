import java.util.*;

    /*
     1. The card game
     Think for a moment about a card game that you’d enjoy playing, and one you
     know some of the rules for.
     • Create a deck of cards, either a standard deck, or a deck that’s specialized to
     the card game you want to create.
     • Shuffle your deck.
     • Deal your players’ hands. Pick the number of players playing, and figure out
     how you’ll deal the cards, one at a time to each hand, or some other way.
     • Evaluate your players’ hands for card combinations that are important to the
     game.
     • Use a combination of java.util.Collections and List methods to achieve your
     results.

     The card game example: poker
     This game usually has four or more players.
     The dealer shuffles the deck and asks another player to cut the deck.
     The dealer deals the cards one at a time to each player, starting with the player
     on the dealer’s left, until each player has 5 cards.
     Each player evaluates his hand for certain card combinations, called card ranks.
     Each player can discard up to 3 cards.
     The dealer will replace discarded cards from the remaining pile in the order
     they’ve been shuffled.
     Each player re-evaluates his hand if he drew new cards, and bets on his hand.
    */

public class Main {
    public static void main(String[] args) {
        int numPlayers = 4;
        int cardsPerPlayer = 5;

        Deck deck = new Deck();
        deck.shuffle();

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player());
        }

        for (int i = 0; i < cardsPerPlayer; i++) {
            for (Player p : players) {
                p.addCard(deck.dealCard());
            }
        }

        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            System.out.println("Player " + (i + 1) + " hand: " + p.getHand());
            System.out.println("Evaluation: " + p.evaluateHand());
            System.out.println();
        }

        System.out.println("=== After Drawing New Cards ===");
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            p.discardAndDraw(deck, 2); // replace 2 cards
            System.out.println("Player " + (i + 1) + " new hand: " + p.getHand());
            System.out.println("New Evaluation: " + p.evaluateHand());
            System.out.println();
        }
    }
}
