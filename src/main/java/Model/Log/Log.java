package Model.Log;

import Model.RandomString;

import java.util.ArrayList;
import java.util.Date;

enum Delivery {
    PROCESSING, SHIPPED, DELIVERED;
}

public abstract class Log extends RandomString {
    private Date date;
    private ArrayList<String> productIDs = new ArrayList<>();

    public Log() {
        this.date = new Date();
    }

    public Date getDate(){
        return date;
    }

    public abstract String toString();

    public String productsToString(){
        return null;
    }

}
