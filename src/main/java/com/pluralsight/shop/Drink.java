package com.pluralsight.shop;

public class Drink extends MenuItem {
    private DrinkSize drinkSize;
    private String type;

    private String drinkDescription;

    //template for creating the
    public Drink(String name, String type, String drinkDescription) {
        super(name);
        this.type = type;
        this.drinkDescription = drinkDescription;
    }

    //the constructor called when creating a drink when the user places an order
    //copies from the template
    public Drink(Drink template, DrinkSize drinkSize) {
        super(template.getName());
        this.type = template.type;
        this.drinkSize = drinkSize; //to ask the user for the size
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



    public void setDrinkDescription(String drinkDescription) {
        this.drinkDescription = drinkDescription;
    }

    public String getDrinkDescription() {
        return drinkDescription;
    }





    @Override
    public String getDescription() {
        return String.format("%s • %s", drinkSize.getDisplayName(), type);

    }

    @Override
    public double totalPrice() {
        return drinkSize.getPrice();
    }
}
