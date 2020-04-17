package Model.Product;

import Model.Category.Category;

import java.util.ArrayList;
import java.util.HashMap;

public class Product {
    private transient static ArrayList<Product> allProducts = new ArrayList<>();
    private String productID;
    private ArrayList<String> salesmanIDs = new ArrayList<>();
    private String name;
    private String brand;
    private String description;
    private int price;
    private int seenCount;
    private Category category;
    private ArrayList<String> pointIDs = new ArrayList<>();

    //the first argument is salesmanID and the second one is whether is's on sale by that salesman
    private HashMap<String, Boolean> isOnSale = new HashMap<>();
    private HashMap<String, Boolean> hasBeenDeleted = new HashMap<>();
    private HashMap<String, Boolean> confirmationState = new HashMap<>();
    private HashMap<String, Integer> remainder = new HashMap<>();

    public Product(String name, String salesmanID, String brand, String description, int price, int remainder) {
        this.name = name;
        this.salesmanIDs.add(salesmanID);
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.remainder.put(salesmanID, remainder);
        this.confirmationState.put(salesmanID, false);
        this.hasBeenDeleted.put(salesmanID, false);
        this.isOnSale.put(salesmanID, false);
        this.productID=createID();
        this.seenCount=0;
        this.category=null;
    }

    public String createID(){
        return null;
    }

    public float getAveragePoint(){
        return 0;
    }

    public boolean hasAnyComment(){
        return false;
    }

    // it checks that the salesman is among seller of product and
    //the salesman is confirmed by manager and also
    //checks that the salesman hasn't deleted the product
    public boolean doesSalesmanSellProductWithUsername (String username){
        return (this.salesmanIDs.contains(username) && !this.hasBeenDeleted.get(username) && this.confirmationState.get(username));
    }

    public boolean isAvailableBySalesmanWithUsername(String username){
        return false;
    }

}
