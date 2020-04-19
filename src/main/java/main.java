import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

    public static void main(String args[]) throws ParseException {
        System.out.println("hiiiiiiii");
        System.out.println("salam javad");

        String g="23-8-1990 23:09:07";
        SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date d=formatter1.parse(g);
        System.out.println(g);
        System.out.println(new Date());

    }
}
