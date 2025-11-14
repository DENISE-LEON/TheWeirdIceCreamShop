package com.pluralsight.shop;

public class SideItem extends MenuItem {
    private double pricePerItem;
    private int quantity;
    private  String description;

    //template
    public SideItem(String name, double pricePerItem, String description) {
        super(name);
        this.pricePerItem = pricePerItem;
        this.description = description;
    }

    //for ordering purposes
    public SideItem(SideItem template, int quantity) {
        super(template.getName());
        this.pricePerItem = template.pricePerItem;
        this.quantity = 1;

    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getDescription() {
        String desc = String.format("✧ %d × %s  →  $%.2f each",
                getQuantity(), getName(), getPricePerItem());


        return desc;
    }

    //calculates the price
    @Override
    public double totalPrice() {
        return pricePerItem * quantity;
    }


}