    // ------------------------------------------------------- 
	// Assignment 4
	// Written by: Nicole Koran 40281430
	// For COMP 248 Section H2232 – Fall 2023
	// --------------------------------------------------------


/*
 * The "PoSDemo" class serves as a driver program to test and demonstrate the functionality of the 
 * "Sales," "PrePaiCard," and "PoS" classes. It initializes at least five instances of the "PoS" 
 * class with specific characteristics, presents a menu to the user with various actions related to 
 * sales and prepaid cards, and executes the chosen actions based on user input. The driver aims 
 * to showcase the interactions and capabilities of the implemented classes, allowing the user to 
 * manipulate Point of Sale scenarios
 */


import java.util.Scanner;

public class PoSDemo {

    // Array to store instances of the PoS class
    private static PoS[] posArray = new PoS[5];
    private static Scanner scanner = new Scanner(System.in);

    // Main method to run the PoSDemo application
    public static void main(String[] args) {
        welcomeUser();
        initializePoS();
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Thank you for using Concordia CostLessBites Catering Sales Counter Application!");
                    return;
                case 1:
                    displayAllPoS();
                    break;
                case 2:
                    displayOnePoS();
                    break;
                case 3:
                    listPoSsWithSameSalesAmount();
                    break;
                case 4:
                    listPoSsWithSameSalesCategories();
                    break;
                case 5:
                    listPoSsWithSameSalesAndPrepaidCards();
                    break;
                case 6:
                    addPrePaiCardToPoS();
                    break;
                case 7:
                    removePrePaiCardFromPoS();
                    break;
                case 8:
                    updatePrePaiCardExpiry();
                    break;
                case 9:
                    addSalesToPoS();
                    break;
                default:
                    System.out.println("Sorry that is not a valid choice. Try again.");
            }
        }
    }
    
    // Method to welcome the user
    private static void welcomeUser() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("| Welcome to Concordia CostLessBites Catering Sales Counter Application       |");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    // Method to initialize PoS instances with specific characteristics
    private static void initializePoS() {
        // PoS #0 and #1 have the same sales categories distribution but different prepaid cards.
        // PoS instances with different characteristics
        Sales commonSales = new Sales(2, 1, 0, 4, 1);
        posArray[0] = new PoS(commonSales, new PrePaiCard[]{
            new PrePaiCard("Vegetarian", "40825164", 25, 12),
            new PrePaiCard("Carnivore", "21703195", 3, 12)
        });

        posArray[1] = new PoS(commonSales, new PrePaiCard[]{
            new PrePaiCard("Vegan", "40825164", 7, 12),
            new PrePaiCard("Vegetarian", "21596387", 24, 8)
        });

        // PoS #2 has a different sales category distribution and at least 3 prepaid cards.
        posArray[2] = new PoS(new Sales(0, 1, 5, 2, 0), new PrePaiCard[]{
            new PrePaiCard("Pescatarian", "95432806", 1, 6),
            new PrePaiCard("Halal", "42087913", 18, 12),
            new PrePaiCard("Kosher", "40735421", 5, 4)
        });

        // PoS #3 and #4 have the same sales categories distribution and no prepaid cards.
        Sales otherSales = new Sales(3, 2, 4, 1, 2);
        posArray[3] = new PoS(otherSales, null);
        posArray[4] = new PoS(otherSales, null);
    }

    // Method to display the menu options
    private static void showMenu() {
    	System.out.println("\n| What would you like to do?                                                  |");
        System.out.println("| 1 >> See the content of all PoSs                                            |");
        System.out.println("| 2 >> See the content of one PoS                                             |");
        System.out.println("| 3 >> List PoSs with same $ amount of sales                                  |");
        System.out.println("| 4 >> List PoSs with same number of Sales categories                         |");
        System.out.println("| 5 >> List PoSs with same $ amount of Sales and same number of prepaid cards |");
        System.out.println("| 6 >> Add a PrePaiCard to an existing PoS                                    |");
        System.out.println("| 7 >> Remove an existing prepaid card from a PoS                             |");
        System.out.println("| 8 >> Update the expiry date of an existing Prepaid card                     |");
        System.out.println("| 9 >> Add Sales to a PoS                                                     |");
        System.out.println("| 0 >> To quit                                                                |");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.print("Please enter your choice and press <Enter>:");
    }

 // Method to display the content of all PoS instances
    private static void displayAllPoS() {
        System.out.println("Content of each PoS:");
        System.out.println("---------------------");
        for (int i = 0; i < posArray.length; i++) {
            System.out.println("PoS #" + i + ":");
            System.out.println(posArray[i]);
        }
    }

 // Method to display the content of a specific PoS instance chosen by the user
    private static void displayOnePoS() {
        int posNumber;
        boolean validInput = false;
        System.out.print("Which PoS you want to see the content of?");
        
        do {
            if (!validInput) {
                System.out.print("(Enter number 0 to 4): ");
            }
            posNumber = scanner.nextInt();

            if (posNumber < 0 || posNumber >= posArray.length) {
                System.out.println("Sorry but there is no PoS number " + posNumber);
                System.out.print("--> Try again: ");
            } else {
                validInput = true;
            }
        } while (!validInput);

        System.out.println(posArray[posNumber]);
    }


 // Method to list PoS instances with the same total sales amount
    private static void listPoSsWithSameSalesAmount() {
        System.out.println("List of PoSs with same total $ Sales:\n");
        for (int i = 0; i < posArray.length; i++) {
            for (int j = i + 1; j < posArray.length; j++) {
                if (posArray[i].compareTotalSalesValue(posArray[j])) {
                    System.out.println("PoSs " + i + " and " + j + " both have " + posArray[i].totalSales());
                }
            }
        }
    }
    
 // Method to list PoS instances with the same sales categories
    private static void listPoSsWithSameSalesCategories() {
        System.out.println("List of PoSs with same Sales categories:\n");
        for (int i = 0; i < posArray.length; i++) {
            for (int j = i + 1; j < posArray.length; j++) {
                if (posArray[i].compareSalesCategoryCounts(posArray[j])) {
                    System.out.println("PoSs " + i + " and " + j + " both have " + posArray[i].salesBreakdown());
                }
            }
        }
    }
    
 // Method to list PoS instances with the same total sales and the same number of PrePaiCards
    private static void listPoSsWithSameSalesAndPrepaidCards() {
        System.out.println("List of PoSs with same $ amount of sales and same number of PrePaiCards:\n");
        for (int i = 0; i < posArray.length; i++) {
            for (int j = i + 1; j < posArray.length; j++) {
                if (posArray[i].equals(posArray[j])) {
                    System.out.println("PoSs " + i + " and " + j);
                }
            }
        }
    }
    
 // Method to add a PrePaiCard to a specific PoS instance
    private static void addPrePaiCardToPoS() {
        System.out.print("Which PoS to you want to add a PrePaiCard to? (Enter number 0 to 4): ");
        int posNumber = scanner.nextInt();
        System.out.println("Please enter the following information so that we may complete the PrePaiCard-");
        System.out.print("--> Type of PrePaiCard (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vigan): ");
        String cardType = scanner.next();
        System.out.print("--> Id of the prepaid card owner: ");
        String cardHolderId = scanner.next();
        System.out.print("--> Expiry day number and month (separate by a space): ");
        int expiryDay = scanner.nextInt();
        int expiryMonth = scanner.nextInt();
        PrePaiCard newCard = new PrePaiCard(cardType, cardHolderId, expiryDay, expiryMonth);
        posArray[posNumber].addPrePaiCard(newCard);
        System.out.println("You now have " + posArray[posNumber].numberOfPrepaidCards() + " PrePaiCard(s)");
    }
    
 // Method to remove a PrePaiCard from a specific PoS instance
    private static void removePrePaiCardFromPoS() {
        System.out.print("Which PoS you want to remove a PrePaiCard from? (Enter number 0 to 4): ");
        int posNumber = scanner.nextInt();
        if (posArray[posNumber].numberOfPrepaidCards() == 0) {
            System.out.println("Sorry, that PoS has no PrePaiCards");
        } else {
            System.out.print("(Enter number 0 to " + (posArray[posNumber].numberOfPrepaidCards() - 1) + "): ");
            int cardIndex = scanner.nextInt();

            // Get the PrePaiCard at the specified index
            PrePaiCard cardToRemove = posArray[posNumber].getPrepaidCard(cardIndex);

            // Check if the removal was successful
            if (cardToRemove != null && posArray[posNumber].removePrePaiCard(cardToRemove)) {
                System.out.println("PrePaiCard was removed successfully");
            } else {
                System.out.println("Error removing PrePaiCard");
            }
        }
    }
    
    
 // Method to update the expiry date of a PrePaiCard in a specific PoS instance
    private static void updatePrePaiCardExpiry() {
        System.out.print("Which PoS do you want to update a PrePaiCard from? (Enter number 0 to 4): ");
        int posNumber = scanner.nextInt();
        if (posArray[posNumber].numberOfPrepaidCards() == 0) {
            System.out.println("Sorry that PoS has no PrePaiCards");
        } else {
            System.out.print("Which PrePaiCard do you want to update? (Enter number 0 to " + (posArray[posNumber].numberOfPrepaidCards() - 1) + "): ");
            int cardIndex = scanner.nextInt();
            System.out.print("--> Enter new expiry date day number and month (separate by a space): ");
            int newDay = scanner.nextInt();
            int newMonth = scanner.nextInt();
            System.out.println("Expiry Date updated.");
        }
    }

 // Method to add sales to a specific PoS instance
    private static void addSalesToPoS() {
        System.out.print("Which PoS do you want to add Sales to? (Enter number 0 to 4): ");
        int posNumber = scanner.nextInt();
        System.out.print("How many junior, teen, medium, big and family meal menu Enter 5 numbers separated by a space: ");
        int junior = scanner.nextInt();
        int teen = scanner.nextInt();
        int medium = scanner.nextInt();
        int big = scanner.nextInt();
        int family = scanner.nextInt();
        posArray[posNumber].addMealsSales(junior, teen, medium, big, family);
        System.out.println("You now have $" + posArray[posNumber].totalSales());
    }
    
    
}

