package com.pluralsight.shop;

import java.util.ArrayList;

public  class IceCream extends MenuItem{
    protected IceCreamSize iceCreamSize;
    protected ArrayList<String> flavors;
    protected ArrayList<Topping> toppings;
    protected String iceDescription;

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

    public IceCream (IceCream template, ArrayList<Topping> toppings, IceCreamSize iceCreamSize) {
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
}
