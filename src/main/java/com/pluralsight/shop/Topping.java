package com.pluralsight.shop;

import java.util.ArrayList;

public class Topping extends MenuItem {
    private ToppingType toppingType;
   //ArrayList<Topping> toppings;

    //constructor
       public Topping(String name, ToppingType toppingType) {
        super(name);
        this.toppingType = toppingType;
    }

    public ToppingType getToppingType() {
        return toppingType;
    }

    public void setToppingType(ToppingType toppingType) {
        this.toppingType = toppingType;
    }



    @Override
    public String getDescription() {
        String desc = getName() + toppingType.getDisplayName();

        return desc;
    }


    @Override
    public double totalPrice() {
        return toppingType.getExtraCharge();

    }

//    public void addToppings(Topping topping) {
//        toppings.add(topping);
//    }

//make to string pretty
    @Override
    public String toString() {
        return "Chosen flavors" +  " " + getName();
    }
}