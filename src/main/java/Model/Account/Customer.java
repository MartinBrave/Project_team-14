package Model.Account;

import java.io.*;
import java.util.ArrayList;

public class Customer extends Account implements Serializable {
    private int credit;
    private ArrayList<Customer> allCustomers;
    private ArrayList<String> cartItems=new ArrayList<>();    //only contains productIDs

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

    @Override
    public String toString() {
        return this.toStringGenerals() + "Credit: " + this.getCredit();
    }
}
