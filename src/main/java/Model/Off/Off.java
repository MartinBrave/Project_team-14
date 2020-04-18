package Model.Off;

import Model.RandomString;

import java.io.Serializable;
import java.util.Date;

public abstract class Off extends RandomString {
    private Date start;
    private Date end;
    private int percentage;

    public boolean isAuthenticAccordingToDate(){
        return false;
    }
}
