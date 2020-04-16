package Model.Log;

import java.io.*;
import Model.Account.Salesman;

import java.util.ArrayList;
import java.util.Random;

public class BuyLog extends Log implements Serializable{
    private transient static ArrayList<BuyLog> allBuyLogs=new ArrayList<>();
    private Salesman salesman;
    private int payAmount;
    private int offAmountByCode;
    private String deliveryState;
    

    @Override
    public String createID() {
        return null;
    }


    @Override
    public String toString() {
        return null;
    }
}
