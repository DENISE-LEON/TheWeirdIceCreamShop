package com.pluralsight;

import com.pluralsight.shop.IceCream;
import com.pluralsight.userInterface.UserInterface;
public class TheWeirdIceCreamShop {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        userInterface.welcomeMessage();
       userInterface.displayMenu();

        //tests
       // IceCream iceCream = new IceCream("p", )
        userInterface.iceCreamOrderProcess();
    }
}
