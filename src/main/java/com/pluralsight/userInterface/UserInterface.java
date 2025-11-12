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
        //matches the user int to the actual cup using the index
        IceCreamCup cupChoice = IceCreamCup.toIndex(choice);

        System.out.println("next chose a size");
        IceCreamSize.displaySizeOptions();
        int size = scanner.nextInt();

    }

}
