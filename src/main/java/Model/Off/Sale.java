package Model.Off;

import Model.Confirmation;
import Model.Product.Product;
import Model.RandomString;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import static Model.Storage.*;

public class Sale extends Off implements Serializable {
    private ArrayList<String> productIDs;
    private String saleID;
    private String salesmanID;
    private Confirmation confirmationState;

    public Sale(String start, String end, int percentage, String salesmanID) throws ParseException {
        super(start, end, percentage);
        this.saleID = createID();
        this.salesmanID = salesmanID;
        confirmationState = Confirmation.CHECKING;
        allSales.add(this);
    }

    public void addProductToSale(String productID) {
        productIDs.add(productID);
    }

    public boolean isConfirmed() {
        return confirmationState.equals(Confirmation.ACCEPTED);
    }

    public boolean isChecking(){
        return confirmationState.equals(Confirmation.CHECKING);
    }

    public boolean isAuthentic() {
        return (isConfirmed() && isAuthenticAccordingToDate());
    }

    public boolean doesContainProduct(String productID) {
        return productID.contains(productID);
    }

    public String getSaleID() {
        return saleID;
    }

    public ArrayList<String> listProducts() {
        return productIDs;
    }

    // the method below return the best price of a product with specific salesman
    //after all possible sales

    public static int getPriceAfterSale(String productID, String salesmanID) {
        int price = Product.getProductWithID(productID).getPriceBySalesmanID(salesmanID);
        if (isProductInSaleWithID(productID, salesmanID)) {
            return price * getMaxSalePercentage(productID, salesmanID) / 100;
        } else {
            return price;
        }
    }

    public Sale getSaleByID(String saleID) {
        for (Sale sale : allSales) {
            if (sale.saleID.equals(saleID)) {
                return sale;
            }
        }
        return null;
    }

    //checks for a product with specific salesman whether the product is in sale
    //by the salesman or not

    public static boolean isProductInSaleWithID(String productID, String salesmanID) {
        return getMaxSalePercentage(productID, salesmanID) != -1;
    }

    //it checks all sales for a specific product and salesman and return
    //the highest sale percentage for that

    private static int getMaxSalePercentage(String productID, String salesmanID) {
        int percentage = -1;
        for (Sale sale : allSales) {
            if (sale.isAuthentic() && sale.salesmanID.equals(salesmanID) && sale.productIDs.contains(productID)) {
                if (sale.percentage > percentage) {
                    percentage = sale.percentage;
                }
            }
        }
        return percentage;
    }

    public static ArrayList<String> getCheckingSales(){
        ArrayList<String> arrayList = new ArrayList<>();
        for(Sale sale :allSales){
            if(sale.isChecking()){
                arrayList.add(sale.saleID);
            }
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append("Products: " + "\n");
        for (String ID : productIDs) {
            result.append(Product.getNameByID(ID)).append("\n");
        }
        return result.toString();
    }

    public String createID() {
        return RandomString.createID("Sale");
    }


}
