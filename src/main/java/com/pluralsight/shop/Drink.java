package com.pluralsight.shop;

public class Drink extends MenuItem {
    private DrinkSize drinkSize;
    private String type;
    private boolean extraIce;
    private boolean extraSugar;
    private String drinkDescription;

    //template for creating the
    public Drink(String name, String type, boolean extraIce, boolean extraSugar, String drinkDescription) {
        super(name);
        this.type = type;
        this.extraIce = extraIce;
        this.extraSugar = extraSugar;
        this.drinkDescription = drinkDescription;
    }

    //the constructor called when creating a drink when the user places an order
    //copies from the template
    public Drink(Drink template, DrinkSize drinkSize) {
        super(template.getName());
        this.type = template.type;
        this.extraIce= template.extraIce;
        this.extraSugar = template.extraSugar;
        this.drinkSize = drinkSize;
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
