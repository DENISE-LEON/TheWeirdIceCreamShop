package com.pluralsight.shop;

public enum DrinkSize {
    MINI_CUP("mini cutie cup", 2.50), JUST_RIGHT("just right cup", 4.25), GRANDE("grande no ariana cup", 7.00);
    private final String displayName;
    private final double price;

    public String getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }

    DrinkSize(String displayName, double price) {
        this.displayName = displayName;
        this.price = price;
    }
}
