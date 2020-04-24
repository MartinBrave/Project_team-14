package Model.Off;

import Model.Account.Customer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class SpecialOffCode implements Runnable {

    private int timeInMinute;
    private int ceiling;
    private boolean activeness;
    private int percentage;
    private int numberOfTimesItCanBeUsed;

    //we call the function when eveything else is initialised
    public void activate(){
        run();
    }

    public void deactivate(){
        activeness=false;
    }

    public void setActiveness(boolean activeness) {
        this.activeness = activeness;
    }

    public void setTimeInMinute(int timeInMinute) {
        this.timeInMinute = timeInMinute;
    }

    public void setCeiling(int ceiling){
        this.ceiling=ceiling;
    }

    public void setNumberOfTimesItCanBeUsed(int numberOfTimesItCanBeUsed){
        this.numberOfTimesItCanBeUsed=numberOfTimesItCanBeUsed;
    }

    public void setPercentage(int percentage){
        this.percentage=percentage;
    }

    @Override
    public void run() {
        if(!activeness){
            return;
        }
        Date nowDate = new Date();
        Date tomorrowDate = new Date(nowDate.getTime() + TimeUnit.HOURS.toMillis(24)); // Adds 24 hours
        Format formatter = new SimpleDateFormat("dd-MMM-yy hh-MM-ss");
        String today = formatter.format(nowDate);
        String tomorrow = formatter.format(tomorrowDate);
        try{
            new OffCode(today,tomorrow,percentage,ceiling,numberOfTimesItCanBeUsed,
                    new ArrayList<>(Collections.singleton(Customer.getRandomUsername())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(timeInMinute*60*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
