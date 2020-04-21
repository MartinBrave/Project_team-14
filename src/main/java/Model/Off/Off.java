package Model.Off;

import Model.RandomString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Off extends RandomString {
    protected Date start;
    protected Date end;
    protected int percentage;

    //start and end must be in format "dd-MM-yyyy HH-mm-ss" otherwise exception will be thrown

    public Off(String start, String end, int percentage) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        this.start = formatter.parse(start);
        this.end = formatter.parse(end);
        this.percentage = percentage;
    }

    public boolean isAuthenticAccordingToDate() {
        Date now = new Date();
        return now.before(end) && now.after(start);
    }

    public String toString() {
        String result = "";
        result += "Sale Percentage: " + percentage + "\n";
        result += "Start Date: " + start.toString() + "\n";
        result += "End Date: " + end.toString() + "\n";
        return result;
    }
}
