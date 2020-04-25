package Controller.DataBase;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;

public abstract class DataBase {

    abstract void updateCustomers() throws IOException, ClassNotFoundException;

    abstract void updateBosses() throws IOException, ClassNotFoundException;

    abstract void updateSalesmen() throws IOException, ClassNotFoundException;

    abstract void updateCategories() throws IOException, ClassNotFoundException;

    abstract void updateBuyLogs() throws IOException, ClassNotFoundException;

    abstract void updateSales() throws IOException, ClassNotFoundException;

    abstract void updateOffCodes() throws IOException, ClassNotFoundException;

    abstract void updateSpecialOffCodes() throws IOException, ClassNotFoundException;

    abstract void updateProducts() throws IOException, ClassNotFoundException;

    abstract void updateComments() throws IOException, ClassNotFoundException;

    abstract void updatePoints() throws IOException, ClassNotFoundException;

    public static void makeDirectories() throws IOException {

      //  FileUtils.cleanDirectory(new File("src\\main\\resources\\DataBase"));

        File file = new File("src\\main\\resources\\DataBase");
        file.mkdirs();
        File file2 = new File("src\\main\\resources\\DataBase\\Bosses");
        file2.mkdirs();
        File file3 = new File("src\\main\\resources\\DataBase\\Customers");
        file3.mkdirs();
        File file4 = new File("src\\main\\resources\\DataBase\\Salesmen");
        file4.mkdirs();
        File file5 = new File("src\\main\\resources\\DataBase\\Products");
        file5.mkdirs();
        File file6 = new File("src\\main\\resources\\DataBase\\Categories");
        file6.mkdirs();
        File file7 = new File("src\\main\\resources\\DataBase\\BuyLogs");
        file7.mkdirs();
        File file8 = new File("src\\main\\resources\\DataBase\\OffCodes");
        file8.mkdirs();
        File file9 = new File("src\\main\\resources\\DataBase\\Sales");
        file9.mkdirs();
        File file10 = new File("src\\main\\resources\\DataBase\\SpecialOffCodes");
        file10.mkdirs();
        File file11 = new File("src\\main\\resources\\DataBase\\Comments");
        file11.mkdirs();
        File file12 = new File("src\\main\\resources\\DataBase\\Points");
        file12.mkdirs();
    }

    public static void storeObjectInFile(Object obj, String address) throws IOException {
        FileOutputStream file = new FileOutputStream(address);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(obj);
        out.close();
        file.close();
    }

    public static void makeObjectFromFile(String address) throws IOException, ClassNotFoundException {

    }


    public static ArrayList<String> listAllFileNamesInDirectory(String directory) {
        ArrayList<String> results = new ArrayList<>();
        File[] files = new File(directory).listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }
        return results;
    }

}
