package Model.Account;

import Model.RandomString;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import static Model.Storage.*;

public class Customer extends Account implements Serializable {
    private int credit;
    private ArrayList<String> cartItems = new ArrayList<>();    //only contains productIDs

    public Customer(String username, String password, String firstName, String secondName, String Email, String telephone, String role, int credit) {
        super(username, password, firstName, secondName, Email, telephone, role);
        this.credit = credit;
        allCustomers.add(this);
    }

    public int getCredit() {
        return credit;
    }

    public static boolean isCreditEnoughAccordingToCart() {
        return false;
    }

    public boolean isThereCustomerWithUsername(String username) {
        for (Customer customer : allCustomers) {
            if (customer.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    //we get random user for the special off code class

    public static String getRandomUsername() {
        Random random = new Random();
        int rand = random.nextInt(allCustomers.size());
        return allCustomers.get(rand).getUsername();
    }

    @Override
    public String toString() {
        return super.toString() + "Credit: " + this.getCredit();
    }

}
