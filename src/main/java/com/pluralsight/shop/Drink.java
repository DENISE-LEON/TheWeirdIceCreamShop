package com.pluralsight.shop;

public class Drink extends MenuItem {
    private DrinkSize drinkSize;
    private String type;
    private boolean extraIce;
    private boolean extraSugar;
    private String drinkDescription;

    public Drink(String name, DrinkSize drinkSize, String type, boolean extraIce, boolean extraSugar, String drinkDescription) {
        super(name);
        this.drinkSize = drinkSize;
        this.type = type;
        this.extraIce = extraIce;
        this.extraSugar = extraSugar;
        this.drinkDescription = drinkDescription;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }

    public String getType() {
        return type;
    }

    public boolean isExtraIce() {
        return extraIce;
    }

    public boolean isExtraSugar() {
        return extraSugar;
    }

    public void setDrinkDescription(String drinkDescription) {
        this.drinkDescription = drinkDescription;
    }

    public String getDrinkDescription() {
        return drinkDescription;
    }

    public void addExtraIce() {
        this.extraIce = true;
    }

    public void addExtraSugar() {
        this.extraSugar = true;
    }

    public void removeExtraIce() {
        this.extraIce = false;
    }

    public void removeExtraSugar() {
        this.extraSugar = false;
    }

    @Override
    public String getDescription() {
        String desc = drinkSize + " " + type;

        if (extraIce) {
            desc += "+ extra ice";
        }
        if (extraSugar) {
            desc += "+ extra sugar";
        }



        return desc;
    }

    @Override
    public double totalPrice() {
        return drinkSize.getPrice();
    }
}
