package com.pluralsight.userInterface;

import com.pluralsight.shop.*;
import com.pluralsight.shop.IceCreamShop;

import java.util.ArrayList;
import java.util.Scanner;

import com.pluralsight.util.*;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    IceCreamShop weirdIceCreamShop = new IceCreamShop();
    ReceiptWriter receiptWriter = new ReceiptWriter();

    // instead of making a new Order every time in each method
    private Order currentOrder = new Order();

    public void welcomeMessage() {
        System.out.println("Welcome to" + " " + weirdIceCreamShop.getName());
    }

    public void displayMenu() {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         ✧ WHAT WOULD YOU LIKE? ✧     ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1) Place an order                   ║");
        System.out.println("║  0) Exit                             ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Your choice: ");
        int menuChoice = scanner.nextInt();
        scanner.nextLine();

        switch (menuChoice) {
            case 1:
                orderProcess();
                break;
            case 0:
                System.out.println("Bye bye");
                System.exit(0);
        }

    }


    //method for placing order
    public void orderProcess() {
        //loop
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║          🍨 WHAT WOULD YOU LIKE? 🍨      ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  1) Custom Ice Cream                     ║");
        System.out.println("║  2) Signature Ice Creams                 ║");
        System.out.println("║  3) Drinks                               ║");
        System.out.println("║  4) Side Items                           ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  5) Checkout                             ║");
        System.out.println("║  6) View Order Summary                   ║");
        System.out.println("║  0) Cancel Order                         ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.print("Your choice: ");


        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                iceCreamOrderProcess();
                break;
            case 2:
                signatureOrderProcess();
                break;
            case 3:
                drinkOrderProcess();
                break;
            case 4:
                sideOrderProcess();
                break;
            case 5:
                checkOutProcess();
                break;
            case 6:
                viewOrderProcess(); //allows the user to view their order and
                break;
            case 0:
                System.out.println("Order canceled.");
                currentOrder = new Order(); //creates a new order
                break;
        }
    }

    //custom order
    public void iceCreamOrderProcess() {
        IceCreamCup.displayCupOptions();
        System.out.println("Please chose a cup");
        System.out.println("Your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        //matches the user int to the actual cup using the index
        IceCreamCup cupChoice = IceCreamCup.toIndex(choice);

        System.out.println("next chose a size");

        IceCreamSize.displaySizeOptions();
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.println("your choice:");
        //a bridge between the users int input and the cup choice
        IceCreamSize sizeChoice = IceCreamSize.toIndex(size);

        //new ice cream created that has cup and size. other properties are added later using setters
        IceCream iceCream = new IceCream(sizeChoice, cupChoice);


        //part 2 of ordering the ice cream
        //display the flavors

        //bool used to validate the user input and loop if the input is not good
        //set to false so that the program runs at least once
        boolean validFlavors = false;

        //temp list for the flavors the user chooses
        ArrayList selectedFlavors = new ArrayList<>();
        while (!validFlavors) {


            //add the flavor to the ice cream
            System.out.println("now it's time to chose flavors");

            //notifiy the user of the limit to avoid oopsies
            System.out.println("please be aware that the" + " " + sizeChoice.getDisplayName() + " " + "only allows for" + " " + sizeChoice.getAmtOfScoops() + " " + "scoops/flavors");

            //displaying the flavors to the user to choose from
            ArrayList<String> flavors = weirdIceCreamShop.getFlavorMenu();

            //calls a display method inside of the ice cream shop class
            weirdIceCreamShop.flavorMenuDisplay();

            //pretty formating for the example
            System.out.println("╔════════ EXAMPLE INPUT ═════════╗");
            System.out.println("║  Ex: 1,3,5                     ║");
            System.out.println("║  Picks: Raspberry Berry,       ║");
            System.out.println("║         Strawberry Swirl,      ║");
            System.out.println("║         Pistachio              ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.println("Your choice:");

            //String in order to take in multiple options at once
            String flavorChoice = scanner.nextLine();

            //seperate the inputs using the commas
            String[] choices = flavorChoice.split(",");

            //incase the user tries to pick more flavors than allowed
            if (choices.length > sizeChoice.getAmtOfScoops()) {
                System.out.println("Please try again...");
                System.out.println("You've selected more scoops than allowed");
            } else {
                // if the length is valid
                //then we want to make sure the flavors are valid
                for (String flavIndex : choices) {
                    int index = Integer.parseInt(flavIndex) - 1;
                    if (index > flavors.size() - 1 || index < 0) {
                        System.out.println("Sorry invalid flavor choice");
                    } else {
                        selectedFlavors.add(flavors.get(index)); //adds to the array list of flavors
                    }
                }
                //all flavors have been added to selected flavors arraylist
                //sets flavor list to selected flavors
                iceCream.setFlavors(selectedFlavors);
                //exits out of the loop
                validFlavors = true;
            }
        }


        System.out.println("༻✧ CHOSEN FLAVORS ✧༺");
        System.out.println("-----------------------------------------");
        System.out.println(iceCream.getFlavors());
        System.out.println("-----------------------------------------");


        //add toppings
        System.out.println("time to accessorize your ice cream with yummy toppings");

        ArrayList<Topping> selectedToppings = new ArrayList<>();
        boolean validToppings = true;
        do {
            ArrayList<Topping> toppings = weirdIceCreamShop.getToppingMenu();
            weirdIceCreamShop.toppingMenuDisplay();
            System.out.println("╔══════════ EXAMPLE ══════════╗");
            System.out.println("║  Ex: 1,3,5                  ║");
            System.out.println("║  Toppings:                  ║");
            System.out.println("║     Stardust Sprinkles      ║");
            System.out.println("║     Moon Cheese             ║");
            System.out.println("║     Wizard Bones            ║");
            System.out.println("╚═════════════════════════════╝");

            //create helper meths
            String toppingChoice = scanner.nextLine();
            String[] toppingChoices = toppingChoice.split(",");

            for (String toppingIndex : toppingChoices) {
                int index = Integer.parseInt(toppingIndex) - 1;
                if (index > toppings.size() - 1 || index < 0) {
                    System.out.println("Invalid flavor choice");
                    validToppings = false;
                } else {
                    selectedToppings.add(toppings.get(index));
                    validToppings = true;
                }
                iceCream.setToppings(selectedToppings);
            }
        } while (!validToppings);

        System.out.println("༻✧ CHOSEN FLAVORS ✧༺");
        System.out.println("-----------------------------------------");
        System.out.println(iceCream.getToppings());
        System.out.println("-----------------------------------------");
        //the ice cream is added to the current order
        currentOrder.addItem(iceCream);
        System.out.println("Your ice cream was added to the order:" + iceCream.getDescription());
        viewOrderProcess();

    }

    public void signatureOrderProcess() {

        boolean validChoice = true;

        do {
            System.out.println("Here are the signature ice creams available. Please choose a signature ice cream:");
            //change display methods to include flavors, toppings, and description
            //format
            weirdIceCreamShop.signatureMenuDisplay();

            //temp copy of the menu items
            ArrayList<IceCream> signatures = weirdIceCreamShop.getSignatureTemplate();


            int choice = scanner.nextInt();
            scanner.nextLine();

            //incase user inputs number out of bounds
            if (choice < 1 || choice > signatures.size()) {
                System.out.println("Invalid choice");
                validChoice = false;
                continue; // go back to the top if invalid
            }

            IceCream template = signatures.get(choice - 1);

            //Ask for size
            IceCreamSize.displaySizeOptions();
            int sizeChoice = scanner.nextInt();
            scanner.nextLine();
            IceCreamSize size = IceCreamSize.toIndex(sizeChoice);

            //adds toppings
            System.out.println("How many extra toppings?");
            int extra = scanner.nextInt();
            scanner.nextLine();

            IceCream sigIceCream = new IceCream(template, size, extra);

            System.out.println("Your signature order: " + sigIceCream.getDescription());
            System.out.println("Total: $" + sigIceCream.totalPrice());

            // add signature ice cream to current order
            currentOrder.addItem(sigIceCream);
            System.out.println("Signature ice cream" + sigIceCream.getDescription() + "added to your order");

            validChoice = true;
            //prompt user if want to check out, edit order, or purchse another item, or exit

        } while (!validChoice);

        //insert order summary
        viewOrderProcess();
    }


    public void drinkOrderProcess() {

        ArrayList<Drink> drinks = weirdIceCreamShop.getDrinkTemplate();
        weirdIceCreamShop.drinkMenuDisplay();
        System.out.println("Please choose a drink");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > drinks.size()) {
            System.out.println("Invalid choice.");
            return; //exit if invalid
        }

        Drink template = drinks.get(choice - 1);

        System.out.println("Choose a size:");
        DrinkSize.displaySizeOptions();

        int drinkSize = scanner.nextInt();
        scanner.nextLine();
        DrinkSize sizeChoice = DrinkSize.toIndex(drinkSize);

        Drink drink = new Drink(template, sizeChoice);
        System.out.println("Drink ordered: " + drink.getDescription());
        System.out.println("Total: $" + drink.totalPrice());

        // ✨ ADDED: add drink to current order
        currentOrder.addItem(drink);
        System.out.println("Drink" + drink.getDescription() + "added to your order");

        viewOrderProcess();
    }

    public void sideOrderProcess() {
        //creates a temp copy of the items in the menu list
        ArrayList<SideItem> sides = weirdIceCreamShop.getSideItemTemplate();

        //calls the display method in the weird ice cream shop
        weirdIceCreamShop.sideItemMenuDisplay();
        System.out.println("What would you like?");
        int sideChoice = scanner.nextInt();
        scanner.nextLine();

        if (sideChoice < 1 || sideChoice > sides.size()) {
            System.out.println("Invalid choice");
            return; //exit if invalid
        }

        SideItem template = sides.get(sideChoice - 1);

        System.out.println("How many would you like?");
        int qty = scanner.nextInt();
        scanner.nextLine();


        SideItem side = new SideItem(template, qty);
        side.setQuantity(qty);

        System.out.println(side.getDescription());


        currentOrder.addItem(side);
        System.out.println("Side item:" + side + "added to your order");
        //insert buffered reader
        viewOrderProcess();
    }

    public void checkOutProcess() {

        if (currentOrder.getOrderItems().isEmpty()) {
            System.out.println("Your order is empty. Nothing to checkout.");
            return;
        }

        System.out.println("\n༻✧ ORDER SUMMARY ✧༺");
        currentOrder.getOrderItems().forEach(item ->
                System.out.println("- " + item.getName() + " | $" + String.format("%.2f", item.totalPrice()))
        );
        System.out.println("Total: $" + String.format("%.2f", currentOrder.getTotal()));

        //write receipt
        receiptWriter.recieptWriter(currentOrder);
        System.out.println("Your receipt has been created. 🧾");
        System.out.println("Thank you, come again!");

        //reset for next order
        currentOrder = new Order();
    }

    public void viewOrderProcess() {
        //show current order content


        if (currentOrder.getOrderItems().isEmpty()) {
            System.out.println("Your order is currently empty.");
            return;
        }

        System.out.println("\n╔══════════ CURRENT ORDER ═══════════╗");

        currentOrder.getOrderItems().forEach(item -> {
            System.out.printf("║  %-26s $%.2f%n", item.getName(), item.totalPrice());
        });

        System.out.println("╠════════════════════════════════════╣");
        System.out.printf("║  Total so far:          $%.2f%n", currentOrder.getTotal());
        System.out.println("╚════════════════════════════════════╝\n");
        System.out.println();
        System.out.println();

        System.out.println("Would you like to:");
        System.out.println("""
                1) Continue ordering
                2) Check out
                0) Exit
                """);
        int viewOrderChoice = scanner.nextInt();

        switch (viewOrderChoice) {
            case 1:
                orderProcess();
                break;
            case 2:
                checkOutProcess();
            case 0:
                System.exit(0);
        }

    }

}



