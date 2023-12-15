import java.util.*;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
// CardComparator class for comparing cards
class CardComparator {
    public static final int MAX_CARDS = 5;

    // Compare two cards based on their face values
    public static int compareCards(Card card1, Card card2) {
        // Define a mapping for face values to easily compare cards
        String[] faceValues = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        int faceValueIndex1 = Arrays.asList(faceValues).indexOf(card1.getFace());
        int faceValueIndex2 = Arrays.asList(faceValues).indexOf(card2.getFace());

        return Integer.compare(faceValueIndex1, faceValueIndex2);
    }
}
