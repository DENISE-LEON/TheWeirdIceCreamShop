package com.pluralsight.shop;

import java.util.ArrayList;

public class IceCreamShop {
    private final String name = "The Weird Ice Cream Shop";
    private final String address = "55-555 Eboard St";
    // ArrayList<Drink> drinkTemplates = new ArrayList<>();
    ArrayList<SideItem> sideItemTemplate = new ArrayList<>();
    // ArrayList<IceCream> flavorTemplate = new ArrayList<>();
    ArrayList<String> flavorMenu = new ArrayList<>();


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public IceCreamShop() {

        //drinks.add(new Drink("Water", "water", )
        //side item template items
        sideItemTemplate.add(new SideItem("Sukuna fried fingers", 20.99, "malevolent yummy deep fried sukuna fingers dipped in buffalo sauce"));
        sideItemTemplate.add(new SideItem("Raspberry macaroons", 10.50, "Crispy macaroons made with fresh raspberry"));
        sideItemTemplate.add(new SideItem("El cholesterol macaroon", 15.76, "Pork, butter, cheese all fried. Healthy? No. Worth it? Perchance"));

        //available flavors
        flavorMenu.add("Raspberry Berry");
        flavorMenu.add("Chocolate Fudge");
        flavorMenu.add("Strawberry Swirl");
        flavorMenu.add("Cookies and Cream");
        flavorMenu.add("Pistachio");
        flavorMenu.add("Coffee Mocha");
        flavorMenu.add("Birthday Cake");
        flavorMenu.add("Blue Cheese");
        flavorMenu.add("Butter Pecan");
        flavorMenu.add("Matcha Green Tea");
        flavorMenu.add("Mango Sorbet");
        flavorMenu.add("Pomegranate");
        flavorMenu.add("Pickle Pickle");
        flavorMenu.add("Hot Cheeto");


    }
}

//turn the drink template into a hash map in order to easily search by name
// learn hash maps
