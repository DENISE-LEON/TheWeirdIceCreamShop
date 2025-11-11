package com.pluralsight.shop;

import java.util.ArrayList;

public class IceCream extends MenuItem {
    protected IceCreamSize iceCreamSize;
    //list of flavors and toppings for each order
    protected ArrayList<String> flavors;
    //list of flavors and toppings for each order
    protected ArrayList<Topping> toppings;
    private int extraToppings;
    protected String iceDescription;
    Topping topping;
    IceCreamSize size;

    //SIGNATURE CONSTRUCTORS
    //template for signature ice cream:does not have preset size
    public IceCream(String name, ArrayList<String> flavors, ArrayList<Topping> toppings, String iceDescription) {
        super(name);
        this.flavors = new ArrayList<>(flavors);
        this.toppings = new ArrayList<>(toppings);
        this.iceDescription = iceDescription;
    }

    //order constructor
    //does not have a description
    public IceCream(IceCream template, IceCreamSize iceCreamSize) {
        super(template.getName());
        this.flavors = new ArrayList<>(flavors);
        this.toppings = new ArrayList<>(toppings);
        this.iceCreamSize = iceCreamSize;
    }

    //REGULAR ICE CREAM CONSTRUCORS
    //template

    public IceCream(String name, ArrayList<String> flavors) {
        super(name);
        this.flavors = new ArrayList<>(flavors);
    }

    public IceCream(IceCream template, ArrayList<Topping> toppings, IceCreamSize iceCreamSize) {
        super(template.getName());
        this.flavors = new ArrayList<>(template.flavors);
        this.toppings = new ArrayList<>(template.toppings);
    }

    public IceCreamSize getIceCreamSize() {
        return iceCreamSize;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }


    public String getIceDescription() {
        return iceDescription;
    }

    public void setIceDescription(String iceDescription) {
        this.iceDescription = iceDescription;
    }


    public String getDescription() {
        return iceCreamSize + getName() + flavors + toppings;
    }

    //method to calculate the price
    public double totalPrice() {
        int amt = 0;
        return totalPriceForSize() +  extraToppingCalc(amt); //add in the toppings to calculate price
        //add topping total prie
    }

    public double totalPriceForSize() {
        double price = topping.totalPrice();
        switch (size) {
            case CUTTIE_SIZE:
                return price;
            case JUST_RIGHT:
                return price * 1.25;
            case SIDE_EYE:
                return price * 1.50;
            default:
                //must throw an exception in case size is null
                throw new IllegalArgumentException("Unknown size");
        }
    }

    public double extraToppingCalc(int amt) {
        double price;
        switch (size) {
            case CUTTIE_SIZE:
                return amt * .25;
            case JUST_RIGHT:
                return amt * .50;
            case SIDE_EYE:
                return  amt * .75;
            default:
                throw new IllegalArgumentException("Unknown size");
        }

    }


}
