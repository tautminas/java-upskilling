import java.util.*;

public class Player {
    private List<Card> hand = new ArrayList<>();

    public void addCard(Card card) {
        hand.add(card);
    }

    public void discardAndDraw(Deck deck, int numberToReplace) {
        Random rand = new Random();
        for (int i = 0; i < numberToReplace && !hand.isEmpty(); i++) {
            int index = rand.nextInt(hand.size());
            hand.remove(index);
            hand.add(deck.dealCard());
        }
    }

    public List<Card> getHand() {
        return hand;
    }

    public String evaluateHand() {
        Map<String, Integer> rankCount = new HashMap<>();
        for (Card c : hand) {
            rankCount.put(c.getRank(), rankCount.getOrDefault(c.getRank(), 0) + 1);
        }

        if (rankCount.containsValue(4)) {
            return "Four of a Kind";
        } else if (rankCount.containsValue(3) && rankCount.containsValue(2)) {
            return "Full House";
        } else if (rankCount.containsValue(3)) {
            return "Three of a Kind";
        } else if (Collections.frequency(rankCount.values(), 2) == 2) {
            return "Two Pair";
        } else if (rankCount.containsValue(2)) {
            return "One Pair";
        } else {
            return "High Card";
        }
    }
}
