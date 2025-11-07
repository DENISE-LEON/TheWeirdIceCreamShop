package com.pluralsight.shop;

public class SideItem extends MenuItem {
    private double pricePerItem;
    private  String description;

    public SideItem(String name, double pricePerItem, String description) {
        super(name);
        this.pricePerItem = pricePerItem;
        this.description = description;
    }

    @Override
    public String getDescription() {
        String desc = getName();

        return desc;
    }

    @Override
    public double totalPrice() {
        return pricePerItem;
    }
}
