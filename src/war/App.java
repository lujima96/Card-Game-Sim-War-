package war;

public class App {
    public static void main(String[] args) {
        // a. Instantiate a Deck and two Players, then shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println("*******************************");
        System.out.println("Deck has been shuffled.\n");
        System.out.println("*******************************\n");
        
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        
        // b. Distribute 52 cards to the players using a traditional for loop
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                player1.draw(deck);
                System.out.println("Player 1 drew a card.");
            } else {
                player2.draw(deck);
                System.out.println("Player 2 drew a card.");
            }
        }
        
        System.out.println("\n*******************************");
        System.out.println("Starting the War Game!");
        System.out.println("*******************************\n");
        
        // c. Simulate 26 rounds of flipping and scoring
        for (int round = 1; round <= 26; round++) {
            System.out.println("Round " + round + ":");
            
            Card card1 = player1.flip();
            Card card2 = player2.flip();
            
            if (card1 == null || card2 == null) {
                System.err.println("One of the players has no cards to flip. Ending game.");
                break;
            }
            
            // Use Card.describe() to illustrate the card flip
            System.out.println(player1.getName() + " flipped:");
            card1.describe();
            System.out.println(player2.getName() + " flipped:");
            card2.describe();
            
            // Compare the values and increment scores accordingly
            if (card1.getValue() > card2.getValue()) {
                player1.incrementScore();
                System.out.println(player1.getName() + " wins this round and receives a point.\n");
            } else if (card1.getValue() < card2.getValue()) {
                player2.incrementScore();
                System.out.println(player2.getName() + " wins this round and receives a point.\n");
            } else {
                System.out.println("It's a tie! No points awarded.\n");
            }
        }
        
        // d. Compare final scores
        int score1 = player1.getScore();
        int score2 = player2.getScore();
        
        // e. Print final scores and declare the winner or a draw
        System.out.println("*******************************");
        System.out.println("Game Over!\n");
        System.out.println(player1.getName() + " Final Score: " + score1);
        System.out.println(player2.getName() + " Final Score: " + score2 + "\n");
        
        if (score1 > score2) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (score1 < score2) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println("The game is a draw!");
        }
        System.out.println("*******************************");
    }
}
