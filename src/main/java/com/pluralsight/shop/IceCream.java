package com.pluralsight.shop;

import java.util.ArrayList;

public abstract class IceCream extends MenuItem{
    private ArrayList<Topping> toppings;
    private boolean extraToppings;
    private String iceDescription;

    public IceCream(String name, ArrayList<Topping> toppings, boolean extraToppings, String iceDescription) {
        super(name);
        this.toppings = toppings;
        this.extraToppings = extraToppings;
        this.iceDescription = iceDescription;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public boolean isExtraToppings() {
        return extraToppings;
    }

    public void setExtraToppings(boolean extraToppings) {
        this.extraToppings = extraToppings;
    }

    public String getIceDescription() {
        return iceDescription;
    }

    public void setIceDescription(String iceDescription) {
        this.iceDescription = iceDescription;
    }
}
