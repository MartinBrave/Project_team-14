package Model.Account;

import java.util.ArrayList;

public abstract class Account {
    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private String Email;
    private String telephone;
    private String role;
    private static transient ArrayList<Account> allAccounts=new ArrayList<>();

    public Account(String username, String password, String firstName, String secondName, String Email, String telephone, String role){
        this.username=username;
        this.password=password;
        this.firstName=firstName;
        this.secondName=secondName;
        this.Email=Email;
        this.telephone=telephone;
        this.role=role;
        allAccounts.add(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return Email;
    }

    public String getRole() {
        return role;
    }

    public String getTelephone() {
        return telephone;
    }

    public static boolean isThereAccountWithUsername(String username) {
        return getUserWithUsername(username) == null;
    }

    public static boolean isEmailAuthentic(String Email) {
        return Email.contains("@");
    }

    public static boolean isTelephoneAuthentic(String telephone) {
        return telephone.length() == 11;
    }

    public static Account getUserWithUsername(String username) {
        for (Account account : allAccounts) {
            if (account.getUsername().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }

    public String toStringGenerals() {
        String result = "";
        result = result + "Username: " + this.getUsername() + "\n";
        result = result + "Name: " + this.getFirstName() + " " + this.getSecondName() + "\n";
        result = result + "Email: " + this.getEmail() + "\n";
        result = result + "Telephone: " + this.getTelephone() + "\n";
        result = result + "Role: " + this.getRole() + "\n";
        return result;
    }

    public abstract String toString();

}
