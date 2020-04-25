package Controller.DataBase;

import Model.Account.Boss;
import Model.Account.Customer;
import Model.Account.Salesman;
import Model.Category.Category;
import Model.Log.BuyLog;
import Model.Off.OffCode;
import Model.Off.Sale;
import Model.Off.SpecialOffCode;
import Model.Product.Comment;
import Model.Product.Point;
import Model.Product.Product;

import java.io.*;

import static Model.Storage.*;

public class startOfProgramme extends DataBase {

    public void update() {
        try {
            makeDirectories();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startProgramme() throws IOException, ClassNotFoundException {
        makeDirectories();
        updateBosses();
        updateBuyLogs();
        updateCategories();
        updateComments();
        updateCustomers();
        updateOffCodes();
        updatePoints();
        updateProducts();
        updateSales();
        updateSalesmen();
        updateSpecialOffCodes();
    }


    @Override
    protected void updateCustomers() throws IOException, ClassNotFoundException {
        String path = "src\\main\\resources\\DataBase\\Customers";
        File[] files = new File(path).listFiles();
        assert files != null;
        for (File name : files) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(name.getAbsolutePath()));
            Customer s = (Customer) in.readObject();
            allCustomers.add(s);
        }

    }

    @Override
    protected void updateBosses() throws IOException, ClassNotFoundException {
        String path = "src\\main\\resources\\DataBase\\Bosses";
        File[] files = new File(path).listFiles();
        assert files != null;
        for (File name : files) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(name.getAbsolutePath()));
            Boss s = (Boss) in.readObject();
            allBosses.add(s);
        }
    }

    @Override
    protected void updateSalesmen() throws IOException, ClassNotFoundException {
        String path = "src\\main\\resources\\DataBase\\Salesmen";
        File[] files = new File(path).listFiles();
        assert files != null;
        for (File name : files) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(name.getAbsolutePath()));
            Salesman s = (Salesman) in.readObject();
            allSalesman.add(s);
        }

    }

    @Override
    protected void updateCategories() throws IOException, ClassNotFoundException {
        String path = "src\\main\\resources\\DataBase\\Sales";
        File[] files = new File(path).listFiles();
        assert files != null;
        for (File name : files) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(name.getAbsolutePath()));
            Category s = (Category) in.readObject();
            allCategories.add(s);
        }
    }

    @Override
    protected void updateBuyLogs() throws IOException, ClassNotFoundException {
        String path = "src\\main\\resources\\DataBase\\BuyLogs";
        File[] files = new File(path).listFiles();
        assert files != null;
        for (File name : files) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(name.getAbsolutePath()));
            BuyLog s = (BuyLog) in.readObject();
            allBuyLogs.add(s);
        }

    }

    @Override
    protected void updateSales() throws IOException, ClassNotFoundException {
        String path = "src\\main\\resources\\DataBase\\Sales";
        File[] files = new File(path).listFiles();
        assert files != null;
        for (File name : files) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(name.getAbsolutePath()));
            Sale s = (Sale) in.readObject();
            allSales.add(s);
        }
    }

    @Override
    protected void updateOffCodes() throws IOException, ClassNotFoundException {
        String path = "src\\main\\resources\\DataBase\\OffCodes";
        File[] files = new File(path).listFiles();
        assert files != null;
        for (File name : files) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(name.getAbsolutePath()));
            OffCode s = (OffCode) in.readObject();
            allOffCodes.add(s);
        }

    }

    @Override
    protected void updateProducts() throws IOException, ClassNotFoundException {
        String path = "src\\main\\resources\\DataBase\\Products";
        File[] files = new File(path).listFiles();
        assert files != null;
        for (File name : files) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(name.getAbsolutePath()));
            Product s = (Product) in.readObject();
            allProducts.add(s);
        }

    }

    @Override
    protected void updateComments() throws IOException, ClassNotFoundException {
        String path = "src\\main\\resources\\DataBase\\Comments";
        File[] files = new File(path).listFiles();
        assert files != null;
        for (File name : files) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(name.getAbsolutePath()));
            Comment s = (Comment) in.readObject();
            allComments.add(s);
        }
    }


    @Override
    protected void updateSpecialOffCodes() throws IOException, ClassNotFoundException {
        String path = "src\\main\\resources\\DataBase\\SpecialOffCodes";
        File[] files = new File(path).listFiles();
        assert files != null;
        for (File name : files) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(name.getAbsolutePath()));
            SpecialOffCode s = (SpecialOffCode) in.readObject();
            allSpecialOffCodes.add(s);
        }

    }

    @Override
    protected void updatePoints() throws IOException, ClassNotFoundException {
        String path = "src\\main\\resources\\DataBase\\Points";
        File[] files = new File(path).listFiles();
        assert files != null;
        for (File name : files) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(name.getAbsolutePath()));
            Point s = (Point) in.readObject();
            allPoints.add(s);
        }
    }

}

