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


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Customer: ").append(customerUsername).append("\n");
        result.append("Pay Amount: ").append(payAmount).append("\n");
        result.append("Off Amount: ").append(offAmount).append("\n");
        result.append("Delivery State: ").append(deliveryState).append("\n");
        result.append("Products: " + "\n");
        for (String productID : products.keySet()) {
            result.append("Product Name:").append(Product.getNameByID(productID)).append("\n");
            result.append("Salesman: ").append(products.get(productID)).append("\n");
            result.append("Price: ").append(prices.get(productID)).append("\n");
            if (salePercentage.get(productID) == 0) {
                result.append("The product wasn't on sale." + "\n");
            } else {
                result.append("The product was on sale with percentage: ").append(salePercentage.get(productID)).append("\n");
            }
            result.append("------------------------------------------").append("\n");
        }
        if (wasOffCodeUsed) {
            result.append("No offCode was used.");
        } else {
            result.append("OffCode was used with discount percentage: ").append(offCodePercentage).append("\n");
        }
        return result.toString();
    }
}
