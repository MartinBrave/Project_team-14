package Model.Log;

import Model.RandomString;

import java.io.*;

import java.util.HashMap;

import static Model.Storage.*;

public class BuyLog extends Log implements Serializable {

    //the first argument is productID and the second one is salesmanID
    private HashMap<String, String> products=new HashMap<>();

    //the first argument is productID and the second one is the prices with consideration of possible sales
    private HashMap<String, String> prices=new HashMap<>();

    private String customerUsername;
    private int payAmount;
    private int offAmount;
    private Delivery deliveryState;
    private boolean wasOffCodeUsed;
    private int offCodePercentage;

    public String createID() {
        return RandomString.createID("BuyLog");
    }


    @Override
    public String toString() {
        String result = "";
        result += "Customer: " + customerUsername + "\n";
        result += "Pay Amount: " + payAmount + "\n";
        result += "Off Amount: " + offAmount + "\n";
        result += "Delivery State: " + deliveryState + "\n";
        return null;
    }
}
