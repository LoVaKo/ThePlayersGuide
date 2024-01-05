package TheCard;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private final CardColor color;
    private final CardRank rank;

    //Constructor
    public Card(CardColor color, CardRank rank) {
        this.color = color;
        this.rank = rank;
    }

    public static void createDeck() {
        // Creating a full deck
        List<Card> deck = new ArrayList<>();

        for (CardColor color : CardColor.values()) {
            for (CardRank rank : CardRank.values()) {
                deck.add(new Card(color, rank));
            }
        }

        // Printing deck
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    public static void main(String[] args) {
        createDeck();
    }

    //toString override
    @Override
    public String toString() {
        return "The " + this.color + " " + this.rank;
    }

    //Other methods
    public boolean isSymbolCard() {
        return rank.ordinal() > CardRank.TEN.ordinal();
    }

    public boolean isNumberCard() {
        return rank.ordinal() <= CardRank.TEN.ordinal();
    }
}
