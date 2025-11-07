package com.pluralsight.shop;

public enum IceCreamSize {

    //can use enum to set the prices to size instead of having to use a switch
    CUTTIE_SIZE("Cutie Patootie size",5.50, 1), JUST_RIGHT("Just right",7.00, 2), SIDE_EYE("Side eye size",8.50, 3);
    private final String displayName;
    private final double price;
    private final int amtOfScoops;

    public String getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }

    public int getAmtOfScoops() {
        return amtOfScoops;
    }

    IceCreamSize(String displayName, double price, int amtOfScoops) {
        this.displayName = displayName;
        this.price = price;
        this.amtOfScoops = amtOfScoops;
    }
}



