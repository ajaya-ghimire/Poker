import java.util.*;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;

// Card class represents a playing card.
class Card implements Comparable<Card> {
    private final String face; // face of card ("Ace", "Deuce", …)
    private final String suit; // suit of card ("Hearts", "Diamonds", …)

    // two-argument constructor initializes card's face and suit
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace; // initialize face of card
        this.suit = cardSuit; // initialize suit of card
    }

    // return String representation of Card
    public String toString() {
        return face + " of " + suit;
    }

    // Get the face value of the card
    public String getFace() {
        return face;
    }

    // Get the suit of the card
    public String getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card other) {
        return CardComparator.compareCards(this, other);
    }
}


