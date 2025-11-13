package com.pluralsight.shop;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class IceCreamShop {
    private final String name = "The Weird Ice Cream Shop";
    private final String address = "55-555 Eboard St";
    // ArrayList<Drink> drinkTemplates = new ArrayList<>();
    ArrayList<SideItem> sideItemTemplate = new ArrayList<>();
    ArrayList<IceCream> signatureTemplate = new ArrayList<>();
    ArrayList<String> flavorMenu = new ArrayList<>();
    ArrayList<Topping> toppingMenu = new ArrayList<>();



    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    public ArrayList<String> getFlavorMenu(){
        return this.flavorMenu;
    }

    public ArrayList<Topping> getToppingMenu() {
        return this.toppingMenu;
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


        //topping menu
        //Mystical
        toppingMenu.add(new Topping("Stardust Sprinkles", ToppingType.MYSTICAL));
        toppingMenu.add(new Topping("Moon Crystal Shards", ToppingType.MYSTICAL));
        toppingMenu.add(new Topping("Moon Cheese", ToppingType.MYSTICAL));
        toppingMenu.add(new Topping("Baked Founder Titan Pieces", ToppingType.MYSTICAL));
        toppingMenu.add(new Topping("Wizard Bones",ToppingType.MYSTICAL));

        //Weird
        toppingMenu.add(new Topping("Pickle Confetti", ToppingType.WEIRD));
        toppingMenu.add(new Topping("Hot Cheeto Dust", ToppingType.WEIRD));
        toppingMenu.add(new Topping("Wasabi Crunch", ToppingType.WEIRD));
        toppingMenu.add(new Topping("Marshmallow Mushrooms", ToppingType.WEIRD));

        //Fruit
        toppingMenu.add(new Topping("Raspberry Burst", ToppingType.FRUIT));
        toppingMenu.add(new Topping("Mango Cubes", ToppingType.FRUIT));
        toppingMenu.add(new Topping("Blueberry Gems", ToppingType.FRUIT));
        toppingMenu.add(new Topping("Pineapple Bits", ToppingType.FRUIT));

        //Candy
        toppingMenu.add(new Topping("Mini Gummy Bears", ToppingType.CANDY));
        toppingMenu.add(new Topping("Cotton Candy Floss", ToppingType.CANDY));
        toppingMenu.add(new Topping("Choco Rocks", ToppingType.CANDY));
        toppingMenu.add(new Topping("Caramel Pearls", ToppingType.CANDY));

        //Drizzle
        toppingMenu.add(new Topping("Dark Chocolate Drizzle", ToppingType.DRIZZLE));
        toppingMenu.add(new Topping("Raspberry Syrup", ToppingType.DRIZZLE));
        toppingMenu.add(new Topping("Salted Caramel Swirl", ToppingType.DRIZZLE));
        toppingMenu.add(new Topping("Honey Glaze", ToppingType.DRIZZLE));







        //signature ice creams
       // signatureTemplate.add(new IceCream("Piccolas Cage", IceCreamCup.EDIBLE_GLASS, ))



    }

    //method to add flavors by name
    //MOVE METHOD TO UTIL or UI!!!!!!!
    public void addFlavorByName(ArrayList<String> names, IceCream iceCream) {

        for(String name: names) {//passing list to make moving method easier later
            flavorMenu.stream()
                    .filter(f -> f.equalsIgnoreCase(name)) //only filters the stream (good for displaying purposes)
                    .findFirst() //extracts the first element that matches so that it could be used in the next chain, to add the flavor
                    .ifPresent(iceCream.getFlavors()::add);
        }//what i want to do with the extracted flavor (add it to the array;ist)
    }

    //display available flavors
    public void flavorMenuDisplay() {
        System.out.println(" ");
        IntStream.range(0, flavorMenu.size())
                .forEach(i -> System.out.println((i + 1) + ")" + " " + flavorMenu.get(i)));
    }


    public void toppingMenuDisplay() {
        System.out.println(" ");
        IntStream.range(0, toppingMenu.size())
                .forEach(i -> System.out.println((i + 1) + ")" + " " + toppingMenu.get(i).getName()));
    }
}

//turn the drink template into a hash map in order to easily search by name
// learn hash maps
