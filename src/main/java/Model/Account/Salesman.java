package Model.Account;

import Model.Confirmation;

import java.io.*;

import static Model.Storage.*;

public class Salesman extends Account implements Serializable {
    private String company;
    private Confirmation confirmationState;
    private int credit;

    public Salesman(String username, String password, String firstName, String secondName, String Email, String telephone, String role, String company, int credit) {
        super(username, password, firstName, secondName, Email, telephone, role);
        this.company = company;
        this.credit = credit;
        confirmationState = Confirmation.CHECKING;
        allSalesman.add(this);

    }

    public String getCompany() {
        return company;
    }

    public int getCredit() {
        return credit;
    }

    public boolean isConfirmed() {
        return confirmationState.equals(Confirmation.ACCEPTED);
    }

    public String toString() {
        String result = super.toString();
        result += "Company: " + this.getCompany() + "\n";
        result += "Credit: " + this.getCredit() + "\n";
        result += "Confirmation State: " + this.confirmationState.toString() + "\n";
        return result;
    }

}
