/**
 * Search algorithms for arrays of cards.
 * 
 * @author Chris Mayfield
 * @version 12/29/2015
 */
public class Search {
    
    /**
     * Sequential search.
     */
    public static int findCard0(Card[] cards, Card card) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(card)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Binary search (iterative version).
     */
    public static int findCard(Card[] cards, Card card) {
        int low = 0;
        int high = cards.length - 1;
        while (low <= high) {
            System.out.println(low + ", " + high);
            int mid = (low + high) / 2;                   // step 1
            int comp = cards[mid].compareTo(card);
            
            if (comp == 0) {                              // step 2
                return mid;
            } else if (comp < 0) {                        // step 3
                low = mid + 1;
            } else {                                      // step 4
                high = mid - 1;
            }
        }
        return -1;
    }
    
    /**
     * Binary search (recursive version).
     */
    public static int findCard(Card[] cards, Card card,
                               int low, int high) {
        if (high < low) {
            return -1;
        }
        System.out.println(low + ", " + high);
        int mid = (low + high) / 2;                       // step 1
        int comp = cards[mid].compareTo(card);
        
        if (comp == 0) {                                  // step 2
            return mid;
        } else if (comp < 0) {                            // step 3
            return findCard(cards, card, mid + 1, high);
        } else {                                          // step 4
            return findCard(cards, card, low, mid - 1);
        }
    }
    
    /**
     * Demonstrates how to call the findCard methods.
     */
    public static void main(String[] args) {
        
        // create the standard deck of cards
        Card[] cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        
        // tracing the code
        Card jack = new Card(11, 1);
        System.out.println(findCard(cards, jack));
        System.out.println();
        Card fake = new Card(15, 1);
        System.out.println(findCard(cards, fake));
        System.out.println();
        
        // search for all cards (using recursive version)
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                Card each = new Card(rank, suit);
                System.out.println(findCard(cards, each, 0, 51));
                System.out.println();
            }
        }
    }
    
}