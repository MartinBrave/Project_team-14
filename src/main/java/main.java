import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

    public static void main(String args[]) throws ParseException {
        System.out.println("hiiiiiiii");
        System.out.println("salam javad");
        Format formatter = new SimpleDateFormat("dd-MM-yy hh-MM-ss");
        String today = formatter.format(new Date());
        System.out.println(today);
    }
}
