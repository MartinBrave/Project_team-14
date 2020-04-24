package Model.Log;

import Model.RandomString;

import java.io.Serializable;
import java.util.Date;

public abstract class Log extends RandomString implements Serializable {
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
