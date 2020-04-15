package Model;

import java.util.ArrayList;

public class Person {
    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private String Email;
    private String telephone;
    private String role;
    private static transient ArrayList allPeople;

    public static boolean isTherePersonWithUsername(String username) {
        return false;
    }

    public static boolean isEmailAuthentic(String Email) {
        return false;
    }

    public static boolean isTelephoneAuthentic(String telephone) {
        return false;
    }

    public void viewPersonalData() {

    }

   /* public Manager getPersonWithUsername(){

    }*/

}
