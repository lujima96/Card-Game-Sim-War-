package war;

public class Card {
    // Fields
    private int value;
    private String name;
    private Suit suit;
    
    // Constructor
    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
        this.name = generateName();
    }

    // Creating the names
    private String generateName() {
        String valueName;
        
        switch (value) {
            case 11:
                valueName = "Jack";
                break;
            case 12:
                valueName = "Queen";
                break;
            case 13:
                valueName = "King";
                break;
            case 14:
                valueName = "Ace";
                break;
            default:
                valueName = String.valueOf(value);
        }
        // Combining value with suit
        return valueName + " of " + suit.toString();
    }

    // Getter for value
    public int getValue() {
        return value;
    }
    
    // Setter for value
    public void setValue(int value) {
        this.value = value;
    }
    
    // Getter for name
    public String getName() {
        return name;
    }
    
    // Setter for name
    public void setName(String name) {
        if(name != null) {
            this.name = name;
        } else {
            System.err.println("Name cannot be empty.");
        }
    } 

    // Describe the card
    public void describe() {
        String valueName;
        
        // Convert number value to card name
        switch (value) {
            case 11:
                valueName = "Jack";
                break;
            case 12:
                valueName = "Queen";
                break;
            case 13:
                valueName = "King";
                break;
            case 14:
                valueName = "Ace";
                break;
            default:
                valueName = String.valueOf(value);
        }
        System.out.println("Card Name: " + name);
        System.out.println("Card Value: " + valueName + " (" + value + ")");
    }
} 
