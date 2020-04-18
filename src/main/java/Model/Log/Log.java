package Model.Log;

import Model.RandomString;

import java.util.ArrayList;
import java.util.Date;

public abstract class Log extends RandomString {
    private static transient ArrayList<Log> allLogs = new ArrayList<>();
    private String ID;
    private Date date;
    private ArrayList<String> productIDs = new ArrayList<>();

    public Log() {
        this.ID = createID();
        this.date = new Date();
        allLogs.add(this);
    }

    public Date getDate(){
        return date;
    }

    public String getID() {
        return ID;
    }

    public Log getLogByID(String ID) {
        for (Log log : allLogs) {
            if (log.getID().equals(ID)) {
                return log;
            }
        }
        return null;
    }

    public abstract String toString();

    public String productsToString(){
        return null;
    }

}
