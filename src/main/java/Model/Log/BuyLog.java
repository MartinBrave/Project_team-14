package Model.Log;

import java.io.*;

import Model.Account.Salesman;

import java.util.ArrayList;
import java.util.Random;

public class BuyLog extends Log implements Serializable {
    private transient static ArrayList<BuyLog> allBuyLogs = new ArrayList<>();
    private String salesmanUsername;
    private String customerUsername;
    private int payAmount;
    private int offAmount;
    private String deliveryState;


    @Override
    public String createID() {
        return null;
    }


    @Override
    public String toString() {
        String result = "";
        result += "Salesman: " + salesmanUsername + "\n";
        result += "Customer: " + customerUsername + "\n";
        result += "Pay Amount: " + payAmount + "\n";
        result += "Off Amount: " + offAmount + "\n";
        result += "Delivery State: " + deliveryState + "\n";
        return null;
    }
}
