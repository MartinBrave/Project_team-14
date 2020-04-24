package Model.Off;

import Model.Account.Customer;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class SpecialOffCode implements Runnable, Serializable {

    //for example now every 60 minutes one OffCode is given to a user
    private int timeInMinute = 60;

    //it means for example now the OffCode given now is authentic for 24 hours
    private int durationInHour = 24;
    private int ceiling = 10000;
    private boolean activeness = true;
    private int percentage = 20;
    private int numberOfTimesItCanBeUsed = 1;

    public void activate() {
        activeness = true;
        run();
    }

    public void deactivate() {
        activeness = false;
    }

    public void setActiveness(boolean activeness) {
        this.activeness = activeness;
    }

    public void setTimeInMinute(int timeInMinute) {
        this.timeInMinute = timeInMinute;
    }

    public void setOffCodeDurationInHour(int durationInHour) { this.durationInHour = durationInHour; }

    public void setCeiling(int ceiling) { this.ceiling = ceiling; }

    public void setNumberOfTimesItCanBeUsed(int numberOfTimesItCanBeUsed) {
        this.numberOfTimesItCanBeUsed = numberOfTimesItCanBeUsed;
    }

    public void setPercentage(int percentage) { this.percentage = percentage; }

    @Override
    public void run() {
        if (!activeness) {
            return;
        }
        Date nowDate = new Date();
        Date tomorrowDate = new Date(nowDate.getTime() + TimeUnit.HOURS.toMillis(durationInHour)); // Adds 24 hours
        Format formatter = new SimpleDateFormat("dd-MMM-yy hh-MM-ss");
        String today = formatter.format(nowDate);
        String tomorrow = formatter.format(tomorrowDate);
        try {
            new OffCode(today, tomorrow, percentage, ceiling, numberOfTimesItCanBeUsed,
                    new ArrayList<>(Collections.singleton(Customer.getRandomUsername())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(TimeUnit.MINUTES.toMillis(timeInMinute));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
