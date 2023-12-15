import java.util.*;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
// PokerHandEvaluator class for evaluating and comparing poker hands
class PokerHandEvaluator {
    // Define constants for poker hand types
    public static final int HIGH_CARD = 0;
    public static final int PAIR = 1;
    public static final int TWO_PAIR = 2;
    public static final int THREE_OF_A_KIND = 3;
    public static final int STRAIGHT = 4;
    public static final int FLUSH = 5;
    public static final int FULL_HOUSE = 6;
    public static final int FOUR_OF_A_KIND = 7;
    public static final int STRAIGHT_FLUSH = 8;

    // Evaluate the type of poker hand
    public static int evaluateHand(Card[] hand) {
        Arrays.sort(hand); // Sort the hand by face value
        if (isStraightFlush(hand)) return STRAIGHT_FLUSH;
        if (isFourOfAKind(hand)) return FOUR_OF_A_KIND;
        if (isFullHouse(hand)) return FULL_HOUSE;
        if (isFlush(hand)) return FLUSH;
        if (isStraight(hand)) return STRAIGHT;
        if (isThreeOfAKind(hand)) return THREE_OF_A_KIND;
        if (isTwoPair(hand)) return TWO_PAIR;
        if (isPair(hand)) return PAIR;
        return HIGH_CARD;
    }

    // Compare two poker hands
    public static int compareHands(Card[] hand1, Card[] hand2) {
        int type1 = evaluateHand(hand1);
        int type2 = evaluateHand(hand2);

        if (type1 > type2) return 1;
        if (type1 < type2) return -1;

        // If both hands have the same type, compare their high cards
        return compareHighCards(hand1, hand2);
    }

    // Helper method to check if the hand is a pair
    private static boolean isPair(Card[] hand) {
        Map<String, Integer> faceCounts = new HashMap<>();

        for (Card card : hand) {
            String face = card.getFace();
            faceCounts.put(face, faceCounts.getOrDefault(face, 0) + 1);
        }

        for (int count : faceCounts.values()) {
            if (count == 2) {
                return true;
            }
        }

        return false;
    }

    // Helper method to check if the hand is two pairs
    private static boolean isTwoPair(Card[] hand) {
        Map<String, Integer> faceCounts = new HashMap<>();
        int pairCount = 0;

        for (Card card : hand) {
            String face = card.getFace();
            faceCounts.put(face, faceCounts.getOrDefault(face, 0) + 1);
        }

        for (int count : faceCounts.values()) {
            if (count == 2) {
                pairCount++;
            }
        }

        return pairCount == 2;
    }

    // Helper method to check if the hand is three of a kind
    private static boolean isThreeOfAKind(Card[] hand) {
        Map<String, Integer> faceCounts = new HashMap<>();

        for (Card card : hand) {
            String face = card.getFace();
            faceCounts.put(face, faceCounts.getOrDefault(face, 0) + 1);
        }

        for (int count : faceCounts.values()) {
            if (count == 3) {
                return true;
            }
        }

        return false;
    }

    // Helper method to check if the hand is four of a kind
    private static boolean isFourOfAKind(Card[] hand) {
        Map<String, Integer> faceCounts = new HashMap<>();

        for (Card card : hand) {
            String face = card.getFace();
            faceCounts.put(face, faceCounts.getOrDefault(face, 0) + 1);
        }

        for (int count : faceCounts.values()) {
            if (count == 4) {
                return true;
            }
        }

        return false;
    }

    // Helper method to check if the hand is a flush
    private static boolean isFlush(Card[] hand) {
        String suit = hand[0].getSuit();

        for (Card card : hand) {
            if (!card.getSuit().equals(suit)) {
                return false;
            }
        }

        return true;
    }

    // Helper method to check if the hand is a straight
    private static boolean isStraight(Card[] hand) {
        int[] faceValues = new int[hand.length];

        for (int i = 0; i < hand.length; i++) {
            String face = hand[i].getFace();
            switch (face) {
                case "Deuce":
                    faceValues[i] = 2;
                    break;
                case "Three":
                    faceValues[i] = 3;
                    break;
                case "Four":
                    faceValues[i] = 4;
                    break;
                case "Five":
                    faceValues[i] = 5;
                    break;
                case "Six":
                    faceValues[i] = 6;
                    break;
                case "Seven":
                    faceValues[i] = 7;
                    break;
                case "Eight":
                    faceValues[i] = 8;
                    break;
                case "Nine":
                    faceValues[i] = 9;
                    break;
                case "Ten":
                    faceValues[i] = 10;
                    break;
                case "Jack":
                    faceValues[i] = 11;
                    break;
                case "Queen":
                    faceValues[i] = 12;
                    break;
                case "King":
                    faceValues[i] = 13;
                    break;
                case "Ace":
                    faceValues[i] = 14;
                    break;
            }
        }

        Arrays.sort(faceValues);

        for (int i = 1; i < faceValues.length; i++) {
            if (faceValues[i] != faceValues[i - 1] + 1) {
                return false;
            }
        }

        return true;
    }

    // Helper method to check if the hand is a full house
    private static boolean isFullHouse(Card[] hand) {
        Map<String, Integer> faceCounts = new HashMap<>();

        for (Card card : hand) {
            String face = card.getFace();
            faceCounts.put(face, faceCounts.getOrDefault(face, 0) + 1);
        }

        boolean hasThreeOfAKind = false;
        boolean hasPair = false;

        for (int count : faceCounts.values()) {
            if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 2) {
                hasPair = true;
            }
        }

        return hasThreeOfAKind && hasPair;
    }

    // Helper method to check if the hand is a straight flush
    private static boolean isStraightFlush(Card[] hand) {
        return isFlush(hand) && isStraight(hand);
    }

    // Helper method to compare high cards when hands have the same type
    private static int compareHighCards(Card[] hand1, Card[] hand2) {
        // Sort the hands by face value in descending order
        Arrays.sort(hand1, Comparator.reverseOrder());
        Arrays.sort(hand2, Comparator.reverseOrder());

        for (int i = 0; i < hand1.length; i++) {
            int comparisonResult = hand1[i].compareTo(hand2[i]);
            if (comparisonResult != 0) {
                return comparisonResult;
            }
        }

        return 0; // Hands are equal
    }
}