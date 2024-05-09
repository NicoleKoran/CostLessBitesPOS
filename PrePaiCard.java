    // ------------------------------------------------------- 
	// Assignment 4
	// Written by: Nicole Koran 40281430
	// For COMP 248 Section H2232 – Fall 2023
	// --------------------------------------------------------


/*
 *The "PrePaiCard" class manages information related to prepaid cards, including the card type, card holder ID, 
 *and expiry date. The class provides constructors for default, parameterized, and copy initialization, accessor 
 *methods for all attributes, mutator methods for updating the expiry date and month, a toString method for generating 
 *a formatted string representation of the card details, and an equals method to determine if two PrePaiCard objects are 
 *identical based on their information.
 */


public class PrePaiCard {
    // Constants for prepaid card types
    public static final String CARNIVORE = "Carnivore";
    public static final String HALAL = "Halal";
    public static final String KOSHER = "Kosher";
    public static final String PESCATARIAN = "Pescatarian";
    public static final String VEGETARIAN = "Vegetarian";
    public static final String VEGAN = "Vegan";

    // Attributes
    private String cardType;
    private String cardHolderId; // Student or Employee ID
    private int expiryDay;
    private int expiryMonth;

    // Default constructor
    public PrePaiCard() {
        this.cardType = "";
        this.cardHolderId = "";
        this.expiryDay = 0;
        this.expiryMonth = 0;
    }

    // Constructor with parameters
    public PrePaiCard(String cardType, String cardHolderId, int expiryDay, int expiryMonth) {
        this.cardType = cardType;
        this.cardHolderId = cardHolderId;
        this.expiryDay = (expiryDay >= 1 && expiryDay <= 31) ? expiryDay : 0;
        this.expiryMonth = (expiryMonth >= 1 && expiryMonth <= 12) ? expiryMonth : 0;
    }

    // Copy constructor
    public PrePaiCard(PrePaiCard other) {
        this(other.cardType, other.cardHolderId, other.expiryDay, other.expiryMonth);
    }

    // Accessor methods
    public String getCardType() {
        return cardType;
    }

    public String getCardHolderId() {
        return cardHolderId;
    }

    public int getExpiryDay() {
        return expiryDay;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    // Mutator methods
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setCardHolderId(String cardHolderId) {
        this.cardHolderId = cardHolderId;
    }

    public void setExpiryDay(int expiryDay) {
        this.expiryDay = (expiryDay >= 1 && expiryDay <= 31) ? expiryDay : 0;
    }

    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = (expiryMonth >= 1 && expiryMonth <= 12) ? expiryMonth : 0;
    }

    // toString method
    public String toString() {
        String formattedDay = expiryDay < 10 ? "0" + expiryDay : Integer.toString(expiryDay);
        String formattedMonth = expiryMonth < 10 ? "0" + expiryMonth : Integer.toString(expiryMonth);
        return   "\n" + cardType + " - " + cardHolderId + " - " + formattedDay + "/" + formattedMonth + "." ;
    }

    // equals method
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PrePaiCard other = (PrePaiCard) obj;
        return cardType.equals(other.cardType) &&
               cardHolderId.equals(other.cardHolderId) &&
               expiryDay == other.expiryDay &&
               expiryMonth == other.expiryMonth;
    }
}
