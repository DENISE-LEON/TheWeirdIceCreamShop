package com.pluralsight.shop;

public enum IceCreamCup {
    WAFFLE("Waffle Cone", 1.00, true),
    HAND("No Cup, put your hands out", 0.00, false),
    PAPER_CUP("Paper Cup", 0.00, false),
    EDIBLE_GLASS("Edible Glass Cup", 1.50, true);

    private String displayName;
    private double price;
    private boolean isPremium;

    public String getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPremium() {
        return isPremium;
    }

    IceCreamCup(String displayName, double price, boolean isPremium) {
        this.displayName = displayName;
        this.price = price;
        this.isPremium = isPremium;
    }

    //method to display cup options
    public static void displayCupOptions() {
        System.out.println("\n༻✧ ICE CREAM CUPS ✧༺\n");
        //using a loop to display all options
        int index =1;
        for (IceCreamCup cup: IceCreamCup.values()) { //values gets the values of the cups
            System.out.printf("%d) %-35s $%.2f%n", index++, cup.getDisplayName(), cup.getPrice());
        }

    }

    //method that puts the options into a list
    //this is used to link the users choice(int) to the cup size option using the index
    public static IceCreamCup toIndex(int index) {
        IceCreamCup[] cups = IceCreamCup.values(); //creates a list of the cups that contains the values of each cup
        //incase index is negative or greater than list of cups
        if (index < 1 || index > cups.length) {
            //incase of bad input
            throw new IllegalArgumentException("Invalid cup selection");
        }
        return cups[index -1];
    }
}
