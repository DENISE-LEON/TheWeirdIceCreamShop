package com.pluralsight.shop;

import java.util.ArrayList;

public class IceCreamShop {
    private final String name = "The Weird Ice Cream Shop";
    private final String address = "55-555 Eboard St";
   // ArrayList<Drink> drinkTemplates = new ArrayList<>();
    ArrayList<SideItem> sideItemTemplate = new ArrayList<>();


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public IceCreamShop() {

        //drinks.add(new Drink("Water", "water", )
    //side item template items
        sideItemTemplate.add(new SideItem("Sukuna fried fingers", 20.99,  "malevolent yummy deep fried sukuna fingers dipped in buffalo sauce"));
        sideItemTemplate.add(new SideItem("Raspberry macaroons", 10.50, "Crispy macaroons made with fresh raspberry"));
        sideItemTemplate.add(new SideItem("El cholesterol macaroon", 15.76,"Pork, butter, cheese all fried. Healthy? No. Worth it? Perchance"));



    }
}

//turn the drink template into a hash map in order to easily search by name
// learn hash maps
