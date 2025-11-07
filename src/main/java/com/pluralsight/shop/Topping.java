package com.pluralsight.shop;

public class Topping extends MenuItem {
    private ToppingType toppingType;

    public ToppingType getToppingType() {
        return toppingType;
    }

    public void setToppingType(ToppingType toppingType) {
        this.toppingType = toppingType;
    }

    public Topping(String name, ToppingType toppingType) {
        super(name);
        this.toppingType = toppingType;
    }

    @Override
    public String getDescription() {
        String desc = getName() + toppingType;


        return desc;
    }


    public double totalPriceForSize(IceCreamSize size) {
        double price = toppingType.getExtraCharge();

        switch (size) {
            case CUTTIE_SIZE:
                return price;
            case JUST_RIGHT:
                return price * 1.25;
            case SIDE_EYE:
                return price * 1.50;
            default:
        //must throw an exception in case size is null
        throw new IllegalArgumentException("Unknown size: " + size);
        }

    }


    public double totalPrice() {
        return toppingType.getExtraCharge();
    }
}