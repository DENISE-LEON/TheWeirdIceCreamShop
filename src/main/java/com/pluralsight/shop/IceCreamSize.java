package com.pluralsight.shop;

public enum IceCreamSize {

    //can use enum to set the prices to size instead of having to use a switch
    CUTTIE_SIZE("Cutie Patootie Size",5.50, 1), JUST_RIGHT("Just Right",7.00, 2), SIDE_EYE("Side Eye Size",8.50, 3);
    private final String displayName;
    private final double price;
    private final int amtOfScoops;

    public String getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }

    public int getAmtOfScoops() {
        return amtOfScoops;
    }

    IceCreamSize(String displayName, double price, int amtOfScoops) {
        this.displayName = displayName;
        this.price = price;
        this.amtOfScoops = amtOfScoops;
    }

    //display method
    public static void displaySizeOptions() {
        System.out.println("\n༻✧ ICE CREAM SIZE ✧༺\n");
        int i = 1;
        for(IceCreamSize size: IceCreamSize.values()) {
        System.out.printf("%d)  %-30s $%.2f%n", i++, size.getDisplayName(), size.getPrice());
        }
    }
}



