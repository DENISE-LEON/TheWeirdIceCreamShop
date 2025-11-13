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
                int index = Integer.parseInt(flavIndex)-1;
                if(index>flavors.size()-1 || index<0){
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
        
        Choosen Flavors: 
        
        """ + iceCream.getFlavors());

        //add toppings
        System.out.println("time to accessorize your ice cream with yummy topping");

        ArrayList<Topping> selectedToppings = new ArrayList<>();
        boolean validToppings = true;
        do {


        } while

        }

    }



