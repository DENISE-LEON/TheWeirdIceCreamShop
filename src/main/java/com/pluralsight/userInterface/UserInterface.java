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
        System.out.println("What would you like to do");
        System.out.println("""
                Your options are:
                1) Place an order
                0) Exit
                """);
        int menuChoice = scanner.nextInt();
    }

}
