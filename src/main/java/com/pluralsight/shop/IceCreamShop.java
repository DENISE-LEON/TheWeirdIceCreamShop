package com.pluralsight.shop;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class IceCreamShop {
    private final String name = "The Weird Ice Cream Shop";
    private final String address = "55-555 Mystic St";
    ArrayList<Drink> drinkTemplate = new ArrayList<>();
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

    public ArrayList<String> getFlavorMenu() {
        return this.flavorMenu;
    }

    public ArrayList<Topping> getToppingMenu() {
        return this.toppingMenu;
    }

    public ArrayList<IceCream> getSignatureTemplate() {
        return this.signatureTemplate;
    }

    public ArrayList<Drink> getDrinkTemplate() {
        return this.drinkTemplate;
    }

    public ArrayList<SideItem> getSideItemTemplate() {
        return this.sideItemTemplate;
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
        toppingMenu.add(new Topping("Wizard Bones", ToppingType.MYSTICAL));

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
        signatureTemplate.add(new IceCream("Piccolas Cage", IceCreamCup.EDIBLE_GLASS, new ArrayList<>(java.util.List.of(findFlavor("Chocolate Fudge"), findFlavor("Pickle Pickle"))),
                new ArrayList<>(java.util.List.of(findTopping("Moon Cheese"), findTopping("Pickle Confetti"))), "A chaotic combo of chocolate + raspberry with mystical toppings"));

        signatureTemplate.add(new IceCream("Founding Titan Feast", IceCreamCup.WAFFLE, new ArrayList<>(java.util.List.of(findFlavor("Hot Cheeto"), findFlavor("Pickle Pickle"))),
                new ArrayList<>(java.util.List.of(findTopping("Baked Founder Titan Pieces"), findTopping("Hot Cheeto Dust"))), "Spicy, crunchy, unhinged — a dessert for warriors"));

        signatureTemplate.add(new IceCream("Celestial Matcha", IceCreamCup.PAPER_CUP, new ArrayList<>(java.util.List.of(findFlavor("Matcha Green Tea"), findFlavor("Pistachio"))),
                new ArrayList<>(java.util.List.of(findTopping("Moon Crystal Shards"), findTopping("Dark Chocolate Drizzle"))), "Earthy matcha lifted with cosmic sweetness"));

        signatureTemplate.add(new IceCream("Forbidden Birthday Cake", IceCreamCup.HAND, new ArrayList<>(java.util.List.of(findFlavor("Birthday Cake"), findFlavor("Blue Cheese"))),
                new ArrayList<>(java.util.List.of(findTopping("Cotton Candy Floss"), findTopping("Marshmallow Mushrooms"))), "Sweet, funky, chaotic — absolutely NOT FDA approved"));

        signatureTemplate.add(new IceCream("Mango Hex", IceCreamCup.EDIBLE_GLASS, new ArrayList<>(java.util.List.of(findFlavor("Mango Sorbet"), findFlavor("Pomegranate"))),
                new ArrayList<>(java.util.List.of(findTopping("Mango Cubes"), findTopping("Honey Glaze"))), "Tropical with a spellbinding sour kick"));


        //drinks
        drinkTemplate.add(new Drink("Minty Madness","Mint chocolate chip milkshake",false,true,"Refreshingly chaotic, topped with extra sugar"));
        drinkTemplate.add(new Drink("Yuzu Pop","Sparkling citrus soda",false,false,"Bright, zesty, absolutely unserious"));
        drinkTemplate.add(new Drink("Dark Roast Disaster","Cold brew with caramel drizzle",false,false,"Aggressively caffeinated for finals week vibes"));


    }


    //matches the flavors in the signature ice cream to the ones in the flavor menu
    private String findFlavor(String name) {
        return flavorMenu.stream()
                .filter(f -> f.equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    //matches the toppings in the signature ice cream to the ones in the topping menu
    private Topping findTopping(String name) {
        return toppingMenu.stream()
                .filter(t -> t.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
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

    public void signatureMenuDisplay() {
        System.out.println(" ");
        IntStream.range(0, signatureTemplate.size())
                .forEach(i -> System.out.println((i + 1) + ")" + " " + signatureTemplate.get(i).getName()));
    }

    public void drinkMenuDisplay() {
        System.out.println(" ");
        IntStream.range(0, drinkTemplate.size())
                .forEach(i -> System.out.println((i + 1) + ")" + " " + drinkTemplate.get(i).getName()));
    }


    public void sideItemMenuDisplay() {
        System.out.println(" ");
        IntStream.range(0, sideItemTemplate.size())
                .forEach(i -> System.out.println((i + 1) + ")" + " " + sideItemTemplate.get(i).getName()));
    }
}

//turn the drink template into a hash map in order to easily search by name
// learn hash maps
