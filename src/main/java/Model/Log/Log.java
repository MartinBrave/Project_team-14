package Model.Log;

import Model.RandomString;
import java.util.Date;

public abstract class Log extends RandomString {
    private Date date;

    public Log() {
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public String toString(){
        return "Date: "+getDate().toString();
    };


}
