package com.pluralsight.shop;

import java.util.ArrayList;

public abstract class IceCream extends MenuItem{
    protected IceCreamSize iceCreamSize;
    protected ArrayList<String> flavor;
    protected ArrayList<Topping> toppings;
    protected String iceDescription;



    public IceCream(String name, IceCreamSize iceCreamSize) {
        super(name);
        this.iceCreamSize = iceCreamSize;
        this.flavor = new ArrayList<>();
        this.toppings = new ArrayList<>();
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
