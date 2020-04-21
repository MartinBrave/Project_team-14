package Model.Off;

import java.util.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class SpecialOffCode implements Runnable {

    private int timeInMinute;
    private boolean activeness;

    public void activate(){
        activeness=true;
    }

    public void deactivate(){
        activeness=false;
    }

    public void setTimeInMinute(int timeInMinute) {
        this.timeInMinute = timeInMinute;
    }

    @Override
    public void run() {
        Date nowDate = new Date(); // oldDate == current time
        Date tomorrowDate = new Date(nowDate.getTime() + TimeUnit.HOURS.toMillis(24)); // Adds 2 hours
        Format formatter = new SimpleDateFormat("dd-MMM-yy hh-MM-ss");
        String today = formatter.format(nowDate);
        String tomorrow = formatter.format(tomorrowDate);

        /*new OffCode(today,
        try {
            Thread.sleep(timeInMinute*60*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
