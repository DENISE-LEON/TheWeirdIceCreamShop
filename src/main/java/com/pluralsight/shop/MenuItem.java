package com.pluralsight.shop;

public abstract class MenuItem {
    private String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    //abstract method to calculate the price
    public abstract double totalPrice();
}

