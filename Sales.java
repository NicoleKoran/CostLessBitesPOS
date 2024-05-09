    // ------------------------------------------------------- 
	// Assignment 4
	// Written by: Nicole Koran 40281430
	// For COMP 248 Section H2232 – Fall 2023
	// --------------------------------------------------------


/*
 * The "Sales" class tracks the number of sales for different meal categories, each associated with specific prices. 
 * It includes constructors for default, parameterized, and copy initialization, accessor and mutator methods, a method 
 * to add new sales quantities, a method to calculate the total sales revenue, a method to generate a string representation
 * of the sales breakdown, and a method to check equality between two Sales objects based on their meal category breakdown.
 */



public class Sales {
    // Static constants for the values of each sale
    private static final int JUNIOR_PRICE = 5;
    private static final int TEEN_PRICE = 10;
    private static final int MEDIUM_PRICE = 12;
    private static final int BIG_PRICE = 15;
    private static final int FAMILY_PRICE = 20;

    // Attributes to keep track of the number of sales
    private int juniorSales;
    private int teenSales;
    private int mediumSales;
    private int bigSales;
    private int familySales;

    // Default constructor
    public Sales() {
        this(0, 0, 0, 0, 0);
    }

    // Constructor with 5 integer parameters
    public Sales(int juniorSales, int teenSales, int mediumSales, int bigSales, int familySales) {
        this.juniorSales = juniorSales;
        this.teenSales = teenSales;
        this.mediumSales = mediumSales;
        this.bigSales = bigSales;
        this.familySales = familySales;
    }

    // Copy constructor
    public Sales(Sales other) {
        this(other.juniorSales, other.teenSales, other.mediumSales, other.bigSales, other.familySales);
    }

    // Accessor and mutator methods for all attributes
    public int getJuniorSales() {
        return juniorSales;
    }

    public void setJuniorSales(int juniorSales) {
        this.juniorSales = juniorSales;
    }

    public int getTeenSales() {
        return teenSales;
    }

    public void setTeenSales(int teenSales) {
        this.teenSales = teenSales;
    }

    public int getMediumSales() {
        return mediumSales;
    }

    public void setMediumSales(int mediumSales) {
        this.mediumSales = mediumSales;
    }

    public int getBigSales() {
        return bigSales;
    }

    public void setBigSales(int bigSales) {
        this.bigSales = bigSales;
    }

    public int getFamilySales() {
        return familySales;
    }

    public void setFamilySales(int familySales) {
        this.familySales = familySales;
    }
    
    
    // addSales() method
    public void addSales(int junior, int teen, int medium, int big, int family) {
        this.juniorSales += junior;
        this.teenSales += teen;
        this.mediumSales += medium;
        this.bigSales += big;
        this.familySales += family;
    }

    // SalesTotal() method
    public int salesTotal() {
        return juniorSales * JUNIOR_PRICE + teenSales * TEEN_PRICE + mediumSales * MEDIUM_PRICE + bigSales * BIG_PRICE + familySales * FAMILY_PRICE;
    }

    // toString() method
    public String toString() {
        return juniorSales + " x $5 + " + teenSales + " x $10 + " + mediumSales + " x $12 + " + bigSales + " x $15 + " + familySales + " x $20 ";
    }

    // equals() method
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sales other = (Sales) obj;
        return juniorSales == other.juniorSales && teenSales == other.teenSales && mediumSales == other.mediumSales && bigSales == other.bigSales && familySales == other.familySales;
    }

}
