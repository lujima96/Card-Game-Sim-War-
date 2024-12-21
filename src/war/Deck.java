package war;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
// List of Card objects
	private List<Card> cards;
	
// Constructs deck with 52 cards
	public Deck() {
		cards = new ArrayList<>();
		initializeDeck();
	}

	private void initializeDeck() {
		// values 2 - 14 (2-10, jack=11, queen =12, king=13, Ace = 14
		// adds all combination of suits and values
	for (Suit suit : Suit.values()) {
		for (int value = 2; value <= 14; value++) {
			cards.add(new Card(value, suit));
			}
		}
		
	 }
	// Shuffling the deck
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	// Draws (removes and returns) the top card from the deck
	public Card draw() {
		if (!cards.isEmpty()) {
			return cards.remove(0); //Removes 1st card in the list
		} else {
			System.err.println("Out of cards");
			return null;
		}
	}
	
	// Returns remaining card count
	public int remainingCards() {
		return cards.size();
	}
	
	// Resets deck back to 52 cards
	public void reset() {
		cards.clear();
		initializeDeck();
	}
	
	// Displays all cards in the deck
	public void displayDeck() {
		for(Card card : cards) {
			System.out.println(card.getName() + " (" + card.getValue() + ")");
		}
	}
	
}
