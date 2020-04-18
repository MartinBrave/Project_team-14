package Model.Account;

import java.io.*;
import java.util.ArrayList;

public class Salesman extends Account implements Serializable {
    private String company;
    private boolean confirmationState;
    private int credit;
    private ArrayList<Salesman> allSalesmen;

    public Salesman(String username, String password, String firstName, String secondName, String Email, String telephone, String role, String company, int credit) {
        super(username, password, firstName, secondName, Email, telephone, role);
        this.company = company;
        this.credit = credit;
        confirmationState = false;
    }

    public String getCompany() {
        return company;
    }

    public int getCredit() {
        return credit;
    }

    public boolean isConfirmed() {
        return confirmationState;
    }


    @Override
    public String toString() {
        String result = this.toStringGenerals();
        result += "Company: " + this.getCompany() + "\n";
        result += "Credit: " + this.getCredit() + "\n";
        result += "Confirmation State: " + this.isConfirmed() + "\n";
        return result;
    }

}
