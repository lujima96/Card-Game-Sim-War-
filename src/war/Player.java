package war;

import java.util.ArrayList;
import java.util.List;

public class Player {
    // Fields
    private List<Card> hand;
    private int score;
    private String name;
    
    // Constructor
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }
    
    // Getter for name
    public String getName() {
        return name;
    }
    
    // Setter for name
    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.err.println("Name can't be empty.");
        }
    }
    
    // Getter for score
    public int getScore() {
        return score;
    }
    
    // Getter for hand
    public List<Card> getHand() {
        return hand;
    }
    
    // Describing player and hand
    public void describe() {
        System.out.println("Name: " + name);
        System.out.println("Score: " + score);
        System.out.println("Hand:");
        if (hand.isEmpty()) {
            System.out.println("No cards in hand");
        } else {
            for(Card card : hand) {
                card.describe();
            }
        }
        // Blank line for readability
        System.out.println();
    }
        
    // Flip (remove and return) the top card from the hand
    public Card flip() {
        if (!hand.isEmpty()) {
            return hand.remove(0); // Removes the first card in the list
        } else {
            System.err.println(name + " has no cards to flip.");
            return null;
        }
    }
    
    // Drawing a card from the deck and adding it to the hand
    public void draw(Deck deck) {
        Card drawnCard = deck.draw();
        if (drawnCard != null) {
            hand.add(drawnCard);
            // Removed the print statement to control output via App.java
        } else {
            System.err.println(name + " could not draw a card because the deck is empty.");
        }
    }
    
    // Incrementing the player's score by 1.
    public void incrementScore() {
        score += 1;
        System.out.println(name + "'s score increased to " + score + ".");
    }
}
