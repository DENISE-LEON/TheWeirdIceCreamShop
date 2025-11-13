package com.pluralsight.userInterface;

import com.pluralsight.shop.*;

import com.pluralsight.shop.IceCreamShop;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    IceCreamShop weirdIceCreamShop = new IceCreamShop();

    public void welcomeMessage() {
        System.out.println("Welcome to" + " " + weirdIceCreamShop.getName());
    }

    public void displayMenu() {
        //loop
        System.out.println("What would you like to do");
        System.out.println("""
                Your options are:
                1) Place an order
                0) Exit
                """);
        int menuChoice = scanner.nextInt();

        switch (menuChoice) {
            case 1:
                orderProcess();
                break;
            case 0:
                System.out.println("Bye bye");
                System.exit(0);
                //add a default
        }

    }


    //method for placing order
    public void orderProcess() {
        //loop
        System.out.println("What would you like?");
        System.out.println("""
                1) Order a custom ice cream
                2) Order a signature ice creams
                3) Order a drink
                4) Order side items
                """);

        int choice = scanner.nextInt();

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
            //add a defualt

        }
    }

    //custom order
    public void iceCreamOrderProcess() {
        IceCreamCup.displayCupOptions();
        System.out.println("Please chose a cup");
        int choice = scanner.nextInt();
        scanner.nextLine();
        //matches the user int to the actual cup using the index
        IceCreamCup cupChoice = IceCreamCup.toIndex(choice);

        System.out.println("next chose a size");
        IceCreamSize.displaySizeOptions();
        int size = scanner.nextInt();
        scanner.nextLine();
        IceCreamSize sizeChoice = IceCreamSize.toIndex(size);

        IceCream iceCream = new IceCream(sizeChoice, cupChoice);

        //display the flavors

        boolean validFlavors = false;
        ArrayList selectedFlavors = new ArrayList<>();
        while (!validFlavors) {


            //add the flavor to the ice cream
            System.out.println("now it's time to chose flavors");
            System.out.println("please be aware that the" + " " + sizeChoice.getDisplayName() + " " + "only allows for" + " " + sizeChoice.getAmtOfScoops() + " " + "scoops/flavors");
            //weirdIceCreamShop.flavorMenuDisplay();


            //displaying the flavors to the user to choose from
            ArrayList<String> flavors = weirdIceCreamShop.getFlavorMenu();

            weirdIceCreamShop.flavorMenuDisplay();

            System.out.println("""
                    
                    Ex: 1,3,5
                    Toppings: Raspberry Berry,Strawberry Swirl,Pistachio
                    """);


            String flavorChoice = scanner.nextLine();

            String[] choices = flavorChoice.split(",");

            if (choices.length > sizeChoice.getAmtOfScoops()) {
                System.out.println("Please try again...");
                System.out.println("You've selected more scopps than allowed");
            } else {
                // if the length is valid
                //then we want to make sure the flavors are valid
                for (String flavIndex : choices) {
                    int index = Integer.parseInt(flavIndex) - 1;
                    if (index > flavors.size() - 1 || index < 0) {
                        System.out.println("Sorry invalid flavor choice");
                    } else {
                        selectedFlavors.add(flavors.get(index));
                    }
                }
                //all flavors have been added to selected flavors arr.
                iceCream.setFlavors(selectedFlavors);
                validFlavors = true;
            }
        }


        System.out.println("""
                
                Chosen Flavors:
                
                """ + iceCream.getFlavors());

        //add toppings
        System.out.println("time to accessorize your ice cream with yummy toppings");

        ArrayList<Topping> selectedToppings = new ArrayList<>();
        boolean validToppings = true;
        do {
            ArrayList<Topping> toppings = weirdIceCreamShop.getToppingMenu();
            weirdIceCreamShop.toppingMenuDisplay();
            System.out.println("""
                    Ex: 1,3,5
                    Toppings: Stardust Sprinkles,Moon Cheese,Wizard Bones
                    """);
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

        System.out.println(iceCream.getToppings());


        System.out.println("Would you like to add extra toppings for an extra charge");


    }

    public void signatureOrderProcess() {

        //add some sort of back up loop
        boolean validChoice = true;

        do {
            System.out.println("Here are the signature ice creams available. Please choose a signature ice cream:");
            //change display methods to include flavors, toppings, and description
            //format
            weirdIceCreamShop.signatureMenuDisplay();

            ArrayList<IceCream> signatures = weirdIceCreamShop.getSignatureTemplate();


            int choice = scanner.nextInt();
            IceCream template = signatures.get(choice - 1);

            scanner.nextLine();

            if (choice < 1 || choice > signatures.size()) {
                System.out.println("Invalid choice");
                validChoice = false;
            }


            //Ask for size
            IceCreamSize.displaySizeOptions();
            int sizeChoice = scanner.nextInt();
            scanner.nextLine();
            IceCreamSize size = IceCreamSize.toIndex(sizeChoice);

            //prompt user if want to order as is or change order

            System.out.println("How many extra toppings?");
            int extra = scanner.nextInt();
            scanner.nextLine();

            IceCream sigIceCream = new IceCream(template, size, extra);

            System.out.println("Your signature order: " + sigIceCream.getDescription());
            System.out.println("Total: $" + sigIceCream.totalPrice());

            // insert buffered writer
            //prompt user if want to check out, edit order, or purchse another item, or exit

        } while (!validChoice);

        //insert order summary

    }


    public void drinkOrderProcess() {
        ArrayList<Drink> drinks = weirdIceCreamShop.getDrinkTemplate();
       weirdIceCreamShop.drinkMenuDisplay();
        System.out.println("Please choose a drink");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > drinks.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Drink template = drinks.get(choice - 1);

        System.out.println("Choose a size:");
        DrinkSize.displaySizeOptions();

        int drinkSize = scanner.nextInt();
        DrinkSize sizeChoice = DrinkSize.toIndex(drinkSize);

        Drink drink = new Drink(template, sizeChoice);
        System.out.println("Drink ordered: " + drink.getDescription());
        System.out.println("Total: $" + drink.totalPrice());

        //nsert buffered writer
    }

    public void sideOrderProcess() {

    }


}



