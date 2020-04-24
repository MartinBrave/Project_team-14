package Controller.DataBase;

import java.io.*;

public abstract class DataBase {
    abstract void updateCustomers();
    abstract void updateBosses();
    abstract void updateSalesmen();
    abstract void updateCategories();
    abstract void updateBuyLog();
    abstract void updateSales();
    abstract void updateOffCodes();
    abstract void updateSpecialOffCodes();
    abstract void updateProducts();
    abstract void updateComments();
    abstract void updatePoints();
    protected static void makeDirectories() {
        File file = new File("src\\main\\resources\\DataBase");
        file.mkdirs();
        File file2 = new File("src\\main\\resources\\DataBase\\Bosses");
        file2.mkdirs();
        File file3 = new File("src\\main\\resources\\DataBase\\Customers");
        file3.mkdirs();
        File file4 = new File("src\\main\\resources\\DataBase\\Salesman");
        file4.mkdirs();
        File file5 = new File("src\\main\\resources\\DataBase\\Products");
        file5.mkdirs();
        File file6 = new File("src\\main\\resources\\DataBase\\Category");
        file6.mkdirs();
        File file7 = new File("src\\main\\resources\\DataBase\\BuyLog");
        file7.mkdirs();
        File file8 = new File("src\\main\\resources\\DataBase\\OffCodes");
        file8.mkdirs();
        File file9 = new File("src\\main\\resources\\DataBase\\Sales");
        file9.mkdirs();
        File file10 = new File("src\\main\\resources\\DataBase\\SpecialOffCodes");
        file10.mkdirs();
        File file11 = new File("src\\main\\resources\\DataBase\\Comments");
        file11.mkdirs();
        File file12 = new File("src\\main\\resources\\DataBase\\Point");
        file12.mkdirs();
        File file13 = new File("src\\main\\resources\\DataBase\\Products");
        file13.mkdirs();
    }

    public static void storeObjectInFile(Object obj, String address) throws IOException {
        FileOutputStream file = new FileOutputStream(address);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(obj);
        out.close();
        file.close();
    }

    public static void makeObjectFromFile(String address) throws IOException, ClassNotFoundException {

        FileInputStream file1 = new FileInputStream(address);
        ObjectInputStream in = new ObjectInputStream(file1);
       // new person((person) in.readObject());
        in.close();
        file1.close();
    }

}
