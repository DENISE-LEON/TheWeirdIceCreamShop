package com.pluralsight.shop;

public enum DrinkSize {
    MINI_CUP("mini cutie cup", 2.50),
    JUST_RIGHT("just right cup", 4.25),
    GRANDE("grande no ariana cup", 7.00);

    private final String displayName;
    private final double price;

    public String getDisplayName() {
        return displayName;
    }






    public double getPrice() {
        return price;
    }

    DrinkSize(String displayName, double price) {
        this.displayName = displayName;
        this.price = price;
    }

    public static void displaySizeOptions() {
        System.out.println("\n༻✧ DRINK SIZE ✧༺\n");
        int i = 1;
        for(DrinkSize size: DrinkSize.values()) {
            System.out.printf("%d)  %-30s $%.2f%n", i++, size.getDisplayName(), size.getPrice());
        }
    }

    public static DrinkSize toIndex(int index) {
        DrinkSize[] sizes = DrinkSize.values(); //creates a list of the sizes that contains the values of each drink size
        //incase index is negative or greater than list of cups
        if (index < 1 || index > sizes.length) {
            //incase of bad input
            throw new IllegalArgumentException("Invalid size selection");
        }
        return sizes[index -1];
    }
}
