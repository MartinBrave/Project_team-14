package Controller.DataBase;

import java.io.IOException;

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

import static Model.Storage.*;

public class EndOfProgramme extends DataBase implements Runnable {

    public void updateFiles() throws IOException {
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
    protected void updateCustomers() throws IOException {
        String path = "src\\main\\resources\\DataBase\\Customers\\";
        for (Customer customer : allCustomers) {
            storeObjectInFile(customer, path + customer.getUsername());
        }
    }

    @Override
    protected void updateBosses() throws IOException {
        String path = "src\\main\\resources\\DataBase\\Bosses\\";
        for (Boss boss : allBosses) {
            storeObjectInFile(boss, path + boss.getUsername());
        }
    }

    @Override
    protected void updateSalesmen() throws IOException {
        String path = "src\\main\\resources\\DataBase\\Salesmen\\";
        for (Salesman salesman : allSalesman) {
            storeObjectInFile(salesman, path + salesman.getUsername());
        }
    }

    @Override
    protected void updateCategories() throws IOException {
        String path = "src\\main\\resources\\DataBase\\Categories\\";
        for (Category category : allCategories) {
            storeObjectInFile(category, path + category.getCategoryName());
        }
    }

    @Override
    protected void updateBuyLogs() throws IOException {
        String path = "src\\main\\resources\\DataBase\\BuyLogs\\";
        for (BuyLog buyLog : allBuyLogs) {
            storeObjectInFile(buyLog, path + buyLog.getBuyLogID());
        }
    }

    @Override
    protected void updateSales() throws IOException {
        String path = "src\\main\\resources\\DataBase\\Sales\\";
        for (Sale sale : allSales) {
            storeObjectInFile(sale, path + sale.getSaleID());
        }
    }

    @Override
    protected void updateOffCodes() throws IOException {
        String path = "src\\main\\resources\\DataBase\\OffCodes\\";
        for (OffCode offCode : allOffCodes) {
            storeObjectInFile(offCode, path + offCode.getOffCodeID());
        }
    }

    @Override
    protected void updateProducts() throws IOException {
        String path = "src\\main\\resources\\DataBase\\Products\\";
        for (Product product : allProducts) {
            storeObjectInFile(product, path + product.getProductID());
        }
    }

    @Override
    protected void updateComments() throws IOException {
        String path = "src\\main\\resources\\DataBase\\Comments\\";
        for (Comment comment : allComments) {
            storeObjectInFile(comment, path + comment.getCommentID());
        }
    }

    @Override
    protected void updatePoints() throws IOException {
        String path = "src\\main\\resources\\DataBase\\Points\\";
        for (Point point : allPoints) {
            storeObjectInFile(point, path + point.getPointID());
        }
    }

    @Override
    protected void updateSpecialOffCodes() throws IOException {
        String path = "src\\main\\resources\\DataBase\\SpecialOffCodes\\";
        for (SpecialOffCode specialOffCode : allSpecialOffCodes) {
            storeObjectInFile(specialOffCode, path + specialOffCode.getSpecialOffCodeID());
        }

    }

    @Override
    public void run() {

    }
}
