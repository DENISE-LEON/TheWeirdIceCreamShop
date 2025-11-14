package com.pluralsight.userInterface;

import com.pluralsight.userInterface.*;

import java.util.Scanner;

public class RewardsScreen {
    Scanner scanner = new Scanner(System.in);
    public void aboutRewards() {
        System.out.println("""
                You know what's better than ice cream??
                Getting fun rewards for eating ice cream!!!
                Join our reward system today to start getting rewarded for treating yourself. You deserve it.
                """);
        boolean run = true;
        do {


            System.out.println("""
                    Would you like to:
                    1) Sign in
                    2) Sign Up
                    3) Return to ice cream shop
                    """);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    signInProcess();
                    break;
                case 2:
                    signUpProcess();
                    break;
                case 3:
                    run = false;
            }
        }while (run);

    }

    public void signInProcess() {

        //add if with a for and counter
        System.out.println("Please input your username");
        String username = scanner.nextLine();
        //insert validator and if using bool

        //add if with for and counter
        System.out.println("Please input your password");
        String password = scanner.nextLine();

        System.out.println("Great would you like to");
    }

    public void signUpProcess() {

    }

    public void viewRewards() {

    }

}
