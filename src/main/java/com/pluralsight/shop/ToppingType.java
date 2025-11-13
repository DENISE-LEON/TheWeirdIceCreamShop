package com.pluralsight.shop;

public enum ToppingType {
    MYSTICAL("mystical mystery topping", 2.00, true),
    WEIRD("that doesn't belong on ice cream topping", 1.00, true),
    FRUIT("fruity toppings", 0.75, true),
    CANDY("candy toppings", 0.00, false),
    DRIZZLE("drizzle toppings", 0.00, false);

    private final String displayName;
    private final double extraCharge;
    private boolean isPremium;


    public String getDisplayName() {
        return displayName;
    }

    public double getExtraCharge() {
        return extraCharge;
    }

    public boolean isPremium() {
        return isPremium;
    }

    ToppingType(String displayName, double extraCharge, boolean isPremium) {
        this.displayName = displayName;
        this.extraCharge = extraCharge;
        this.isPremium = isPremium;
    }
}
