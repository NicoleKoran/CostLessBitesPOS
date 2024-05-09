    // ------------------------------------------------------- 
	// Assignment 4
	// Written by: Nicole Koran 40281430
	// For COMP 248 Section H2232 – Fall 2023
	// --------------------------------------------------------


/*
 *The "PoS" class represents a Point of Sale system with attributes for sales and 
 *prepaid cards. It includes constructors for default and parameterized initialization, 
 *methods to compare total sales and meal category quantities between two PoS objects, 
 *methods to retrieve the total sales value, the number of prepaid cards, and the breakdown 
 *of meal sales. Additionally, the class provides methods to add, remove, and update prepaid 
 *cards, add meal sales, check equality between two PoS objects, and generate formatted string 
 *representations of the PoS details, including both meal sales breakdown and prepaid card information. 
 */



public class PoS {
    private Sales sales;
    private PrePaiCard[] prepaidCards;

    // Default constructor
    public PoS() {
        this.sales = new Sales();
        this.prepaidCards = null;
    }

    // Constructor with parameters
    public PoS(Sales sales, PrePaiCard[] prepaidCards) {
        this.sales = new Sales(sales); // Avoid privacy leaks with a new Sales object
        // Deep copy of prepaidCards to avoid privacy leaks
        if (prepaidCards != null) {
            this.prepaidCards = new PrePaiCard[prepaidCards.length];
            for (int i = 0; i < prepaidCards.length; i++) {
                this.prepaidCards[i] = new PrePaiCard(prepaidCards[i]);
            }
        } else {
            this.prepaidCards = null;
        }
    }

    // Method to compare total sales value of two PoS objects
    public boolean compareTotalSalesValue(PoS other) {
        return this.sales.salesTotal() == other.sales.salesTotal();
    }

    // Method to compare sales category counts of two PoS objects
    public boolean compareSalesCategoryCounts(PoS other) {
        return this.sales.equals(other.sales);
    }

    // Method to return total $ sales of a PoS
    public int totalSales() {
        return sales.salesTotal();
    }

    // Method to return the number of prepaid cards
    public int numberOfPrepaidCards() {
        return (prepaidCards == null) ? 0 : prepaidCards.length;
    }

    // Method to add a new PrePaiCard
    public int addPrePaiCard(PrePaiCard newCard) {
        if (prepaidCards == null) {
            prepaidCards = new PrePaiCard[]{newCard};
        } else {
            PrePaiCard[] newCards = new PrePaiCard[prepaidCards.length + 1];
            System.arraycopy(prepaidCards, 0, newCards, 0, prepaidCards.length);
            newCards[prepaidCards.length] = newCard;
            prepaidCards = newCards;
        }
        return prepaidCards.length;
    }

    // Method to remove a pre-paid card
    public boolean removePrePaiCard(PrePaiCard card) {
        if (prepaidCards == null || prepaidCards.length == 0) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < prepaidCards.length; i++) {
            if (prepaidCards[i].equals(card)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false; // Card not found
        }
        PrePaiCard[] newCards = new PrePaiCard[prepaidCards.length - 1];
        System.arraycopy(prepaidCards, 0, newCards, 0, index);
        System.arraycopy(prepaidCards, index + 1, newCards, index, prepaidCards.length - index - 1);
        prepaidCards = newCards;
        return true;
    }

    // Method to update the expiry day and month of a prepaid card
    public void updatePrePaiCardExpiry(PrePaiCard card, int newDay, int newMonth) {
        for (PrePaiCard pCard : prepaidCards) {
            if (pCard.equals(card)) {
                pCard.setExpiryDay(newDay);
                pCard.setExpiryMonth(newMonth);
                break;
            }
        }
    }

    // Method to add meals sales
    public int addMealsSales(int junior, int teen, int medium, int big, int family) {
        sales.addSales(junior, teen, medium, big, family);
        return sales.salesTotal();
    }

    // equals() method
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PoS other = (PoS) obj;
        return this.sales.salesTotal() == other.sales.salesTotal() &&
               this.numberOfPrepaidCards() == other.numberOfPrepaidCards();
    }

    // toString() method
    public String toString() {
        String result =  sales.toString();
        if (prepaidCards == null || prepaidCards.length == 0) {
            result += "\nNo pre-paid cards";
        } else {
            for (PrePaiCard card : prepaidCards) {
                result += card.toString() ;
            }
        }
        return result + "\n";
    }

    // Method to return a string with just the breakdown of the sales
    public String salesBreakdown() {
        return sales.toString();
    }
    
    // Retrieves a PrePaiCard at the specified index from the array of prepaid cards.
    public PrePaiCard getPrepaidCard(int index) {
        if (prepaidCards == null || index < 0 || index >= prepaidCards.length) {
            return null;
        }
        return prepaidCards[index];
    }
}