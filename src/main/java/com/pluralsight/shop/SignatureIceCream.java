package com.pluralsight.shop;

public class SignatureIceCream extends IceCream {


    public SignatureIceCream(String iceCreamName, IceCreamSize iceCreamSize) {
        super(iceCreamName, iceCreamSize);
        switch (iceCreamName) {
            case "The Picolas Cage":
                flavor.add("pickle");
                flavor.add("chocolate");
                flavor.add("mint");
               iceCreamSize = IceCreamSize.SIDE_EYE;

        }

    }
}
