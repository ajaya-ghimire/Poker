import java.util.*;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        System.out.println("==================================");
        System.out.println("Five Card POKER");
        System.out.println("==================================");

        System.out.println("Player 1's Hand:");
        Card[] hand1 = new Card[5];
        for (int i = 0; i < 5; i++) {
            hand1[i] = deck.dealCard();
            System.out.println(hand1[i]);
        }

        System.out.println("\nPlayer 2's Hand:");
        Card[] hand2 = new Card[5];
        for (int i = 0; i < 5; i++) {
            hand2[i] = deck.dealCard();
            System.out.println(hand2[i]);
        }

        int result = PokerHandEvaluator.compareHands(hand1, hand2);

        if (result > 0) {
            System.out.println("\nPlayer 1 wins!");
        } else if (result < 0) {
            System.out.println("\nPlayer 2 wins!");
        } else {
            System.out.println("\nIt's a tie!");
        }
        System.out.println();
    }
}
