package Model.Off;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import static Model.Storage.*;

public class OffCode extends Off implements Serializable {
    private int ceiling;
    private String offCodeID;
    private int numberOfTimesCanBeUsed;
    private ArrayList<String> userNamesCanUseIt = new ArrayList<>();

    public OffCode(String start, String end, int percentage, int ceiling, int numberOfTimesCanBeUsed, ArrayList<String> userNamesCanUseIt) throws ParseException {
        super(start, end, percentage);
        this.ceiling = ceiling;
        this.numberOfTimesCanBeUsed = numberOfTimesCanBeUsed;
        this.userNamesCanUseIt.addAll(userNamesCanUseIt);
        allOffCodes.add(this);

        //because IDs are generally too long I decided to to make the length the random String 5 in order for more comfort
        offCodeID = createID("OffCode");
    }

    private boolean canCustomerUseItWithUsername(String username) {
        return userNamesCanUseIt.contains(username);
    }

    public static boolean isThereOffCodeWithID(String offCodeID) {
        return getOffCodeByID(offCodeID) != null;
    }

    private boolean isAuthenticAccordingToNumberOfTimesCanBeUsed() {
        return this.numberOfTimesCanBeUsed > 0;
    }

    public String getOffCodeID() {
        return offCodeID;
    }

    //it checks whether the code is authentic or not by checking both date and number of times used
    //but before using this method we have to make sure that the codeID is even valid

    public boolean isAuthentic() {
        return isAuthenticAccordingToNumberOfTimesCanBeUsed() && isAuthenticAccordingToDate();
    }

    //this method receives an integer and return the amount of final price after using offCode on that

    public int getFinalPrice(int price) {
        if ((price * percentage) / 100 > ceiling) {
            return price - ceiling;
        } else {
            return (price * percentage) / 100;
        }
    }


    public static boolean isOffCodeAuthenticWithID(String offCodeID) {
        if (getOffCodeByID(offCodeID) == null) {
            return false;
        }
        return getOffCodeByID(offCodeID).isAuthentic();
    }

    public static OffCode getOffCodeByID(String offCodeID) {
        for (OffCode offCode : allOffCodes) {
            if (offCode.offCodeID.equals(offCodeID)) {
                return offCode;
            }
        }
        return null;
    }

    //the method is boolean and if number of times that can be used is a positive number reduces that
    //by one and then return true otherwise doesn't do anything and just return false

    public boolean reduceNumberOfTimesItCanBeUsed() {
        if (numberOfTimesCanBeUsed > 0) {
            numberOfTimesCanBeUsed--;
            return true;
        } else {
            return false;
        }
    }

    //return string formatted off code for boss menu

    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append("Number Of Times Can Be Still Used: ").append(numberOfTimesCanBeUsed).append("\n");
        result.append("Users That Can Use It: " + "\n");
        for (String user : userNamesCanUseIt) {
            result.append(user).append("\n");
        }
        return result.toString();
    }
}
