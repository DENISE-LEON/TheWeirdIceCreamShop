package com.pluralsight.shop;

public enum IceCreamSize {

    //can use enum to set the prices to size instead of having to use a switch
    CUTTIE_SIZE("Cutie Patootie size",2.50), JUST_RIGHT("Just right",4.25), SIDE_EYE("Side eye size",6.00);
    private final String displayName;
    private final double price;

    public String getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }

    IceCreamSize(String displayName, double price) {
        this.displayName = displayName;
        this.price = price;
    }
}



