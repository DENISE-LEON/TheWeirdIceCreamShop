package com.pluralsight.shop;

import java.util.ArrayList;

public class IceCream extends MenuItem {
    private IceCreamSize iceCreamSize;
    //list of flavors and toppings for each order
    private IceCreamCup iceCreamCup;
    private ArrayList<String> flavors;
    //list of flavors and toppings for each order
    private ArrayList<Topping> toppings;
    private int extraToppings;
    private String iceDescription;


    //SIGNATURE CONSTRUCTORS
    //template for signature ice cream:does not have preset size
    public IceCream(String name, IceCreamCup iceCreamCup, ArrayList<String> flavors, ArrayList<Topping> toppings, String iceDescription) {
        super(name);
        this.iceCreamCup = iceCreamCup;
        this.flavors = new ArrayList<>(flavors);
        this.toppings = new ArrayList<>(toppings);
        this.iceDescription = iceDescription;
    }

    //order constructor
    //does not have a description
    public IceCream(IceCream template, IceCreamSize iceCreamSize, int extraToppings) {
        super(template.getName());
        this.iceCreamCup = template.iceCreamCup;
        this.extraToppings = extraToppings;
        this.flavors = new ArrayList<>(template.flavors); //copies the flavors from template
        this.toppings = new ArrayList<>(template.toppings); //copies the toppings for template
        this.iceCreamSize = iceCreamSize;
    }

    //REGULAR ICE CREAM CONSTRUCORS
    //ice cream base

    public IceCream(IceCreamSize iceCreamSize, IceCreamCup iceCreamCup) {
        super("new ice cream");
        this.iceCreamSize = iceCreamSize;
        this.iceCreamCup = iceCreamCup;
        this.flavors = new ArrayList<>();
        this.toppings = new ArrayList<>();
    }

    //remove flavors anfd toppings
//    public IceCream(IceCream template, IceCreamCup iceCreamCup,IceCreamSize iceCreamSize, ArrayList<Topping> toppings, int extraToppings) {
//        super(template.getName());
//        this.iceCreamCup = iceCreamCup;
//        this.iceCreamSize = iceCreamSize;
//        this.flavors = new ArrayList<>(template.flavors);
//        this.toppings = new ArrayList<>(toppings);
//        this.extraToppings = extraToppings;
//    }

    public IceCreamSize getIceCreamSize() {
        return iceCreamSize;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public ArrayList<String> getFlavors() {
        return flavors;
    }
    public void setFlavors(ArrayList<String> flavors){
        this.flavors = flavors;
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
        return " " + iceCreamSize.getDisplayName() + getName() + flavors + toppings;
    }

    //method to calculate the price
    //adds toppings, cup type, size
    public double totalPrice() {
        // int amt = 0;
        return toppings.stream()
                .mapToDouble(t -> toppingPriceForSize(t))
                .sum()
                + extraToppingCalc(extraToppings)
                + iceCreamSize.getPrice()
                + iceCreamCup.getPrice();
        //add topping total prie

        //create a loop to loop through list of toppings and get the total for all of them
    }

    //topping total based on size
    public double toppingPriceForSize(Topping t) {
        //gets the price of topping from the topping type enum class
        double price = t.totalPrice();
        switch (iceCreamSize) {
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

    //multiplies the cost for each extra topping based on the size and amount
    public double extraToppingCalc(int extraToppings) {
        double price;
        switch (iceCreamSize) {
            case CUTTIE_SIZE:
                return extraToppings * .25;
            case JUST_RIGHT:
                return extraToppings * .50;
            case SIDE_EYE:
                return extraToppings * .75;
            default:
                throw new IllegalArgumentException("Unknown size");
        }
    }

    //method to cal


}
