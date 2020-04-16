package Model.Log;

import java.util.ArrayList;
import java.util.Date;

public abstract class Log {
    private ArrayList<Log> allLogs = new ArrayList<>();
    private String ID;
    private Date date;
    private ArrayList<String> productIDs = new ArrayList<String>();

    public Log() {
        this.ID = createID();
        this.date = new Date();
    }

    public String getID() {
        return ID;
    }


    public abstract String createID();

    public abstract String toString();

}
