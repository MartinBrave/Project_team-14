package Model.Log;

import Model.Product.Product;
import Model.RandomString;

import java.io.*;
import java.util.HashMap;

public class BuyLog extends Log implements Serializable {

    //the first argument is productID and the second one is salesmanID
    private HashMap<String, String> products = new HashMap<>();

    //the first argument is productID and the second one is the prices with consideration of possible sales
    private HashMap<String, String> prices = new HashMap<>();

    //the first argument is productID and the second one is sale percentage and it's zero for those that are not on sale
    private HashMap<String, Integer> salePercentage = new HashMap<>();


    private String customerUsername;
    private String offCodeID;
    private int payAmount;
    private int offAmount;
    private Delivery deliveryState;
    private boolean wasOffCodeUsed;
    private int offCodePercentage;

    public BuyLog(HashMap<String, String> products, HashMap<String, String> prices, HashMap<String, Integer> salePercentage, String customerUsername, String offCodeID) {
        this.products = products;
        this.prices = prices;
        this.salePercentage = salePercentage;
        this.customerUsername = customerUsername;
        this.offCodeID = this.offCodeID;
        if (offCodeID.isEmpty()) {
            wasOffCodeUsed = false;
        }
        deliveryState = Delivery.PROCESSING;

    }

    public String createID() {
        return RandomString.createID("BuyLog");
    }

    private StringBuilder toStringSingleProduct(String productID){
        StringBuilder result = new StringBuilder();
        result.append("Product Name:").append(Product.getNameByID(productID)).append("\n");
        result.append("Salesman: ").append(products.get(productID)).append("\n");
        result.append("Price: ").append(prices.get(productID)).append("\n");
        if (salePercentage.get(productID) == 0) {
            result.append("The product wasn't on sale." + "\n");
        } else {
            result.append("The product was on sale with percentage: ").append(salePercentage.get(productID)).append("\n");
        }
        result.append("------------------------------------------").append("\n");
        return result;
    }

    private String toStringProducts() {
        StringBuilder result = new StringBuilder();
        result.append("Products: " + "\n");
        for (String productID : products.keySet()) {
            result.append(toStringSingleProduct(productID));
        }
        return result.toString();
    }

    private String toStringOffCodeUsage() {
        if (wasOffCodeUsed) {
            return "No offCode was used." + "\n";
        } else {
            return "OffCode was used with discount percentage: " + offCodePercentage + "\n";
        }
    }

    @Override
    public String toString() {
        return "Customer: " + customerUsername + "\n" +
                "Pay Amount: " + payAmount + "\n" +
                "Off Amount: " + offAmount + "\n" +
                "Delivery State: " + deliveryState + "\n" +
                toStringOffCodeUsage() + toStringProducts();
    }
}
