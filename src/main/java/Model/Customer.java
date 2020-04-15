package Model;

import java.util.ArrayList;

public class Customer extends Person {
    private int credit;

    //only contains productIDs
    private ArrayList<String> cartItems;

    public static boolean isCreditEnoughAccordingToCart() {
        return false;
    }
}
