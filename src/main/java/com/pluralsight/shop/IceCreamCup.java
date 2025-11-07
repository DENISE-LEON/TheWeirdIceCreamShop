package com.pluralsight.shop;

public enum IceCreamCup {
    WAFFLE("waffle cone", 1.00, true),
    HAND("no cup, put your hands out", 0.00, false),
    PAPER_CUP("paper cup", 0.00, false),
    EDIBLE_GLASS("edible glass cup", 1.50, true);

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
}
