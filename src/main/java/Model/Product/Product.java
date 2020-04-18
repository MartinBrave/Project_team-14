package Model.Product;

import Model.Category.Category;
import Model.Confirmation;
import Model.RandomString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class Product extends RandomString implements Serializable {
    private transient static ArrayList<Product> allProducts = new ArrayList<>();
    private ArrayList<String> salesmanIDs = new ArrayList<>();
    private String productID;
    private String name;
    private String brand;
    private String description;
    private int seenCount;
    private Category category;

    //the first argument is salesmanID and the second one is whether is's on sale by that salesman
    private HashMap<String, Boolean> isOnSale = new HashMap<>();
    //the first argument is salesmanID and the second onw is whether it has been deleted by the salesman
    private HashMap<String, Boolean> hasBeenDeleted = new HashMap<>();
    //the first argument is salesmanID and the second onw is whether it has been confirmed by the boss for the salesman
    private HashMap<String, Confirmation> confirmationState = new HashMap();
    //the first argument is salesmanID and the second onw is the remainder number of product by the salesman
    private HashMap<String, Integer> remainder = new HashMap<>();
    //the first argument is salesmanID and the second onw is the price by salesman
    private HashMap<String, Integer> price = new HashMap<>();


    public Product(String name, String salesmanID, String brand, String description, int price, int remainder) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.productID = createID();
        this.seenCount = 0;
        this.category = null;
        this.remainder.put(salesmanID, remainder);
        this.confirmationState.put(salesmanID, Confirmation.CHECKING);
        this.hasBeenDeleted.put(salesmanID, false);
        this.isOnSale.put(salesmanID, false);
        this.salesmanIDs.add(salesmanID);
        this.price.put(salesmanID, price);
        allProducts.add(this);
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Product> getAllProducts() {
        return allProducts;
    }

    public float getAveragePoint() {
        return Point.getAveragePointForProduct(this.productID);
    }

    public int getNumberOfPeopleVoted() {
        return Point.getNumberOfPeopleVotedForProduct(this.productID);
    }

    public boolean isThereAnyPoint() {
        return Point.isTherePointForProduct(this.productID);
    }

    public boolean isThereAnyComment() {
        return Comment.isThereAnyCommentForProduct(this.productID);
    }

    public ArrayList<String> getComments() {
        return Comment.getStringFormattedCommentsForProductWithID(this.productID);
    }

    private boolean isConfirmedForSalesmanWithUsername(String username) {
        return this.confirmationState.get(username).equals(Confirmation.ACCEPTED);
    }

    // it checks that the salesman is among seller of product and
    //the salesman is confirmed by manager and also
    //checks that the salesman hasn't deleted the product
    public boolean doesSalesmanSellProductWithUsername(String username) {
        return (salesmanIDs.contains(username) && !hasBeenDeleted.get(username) && isConfirmedForSalesmanWithUsername(username));
    }

    //we should first check the method doesSalesmanSellProductWithUsername() and then
    //call method below to make sure that the salesman sell it first
    //then checking whether they have remainder or not
    public boolean isAvailableBySalesmanWithUsername(String username) {
        return remainder.get(username) > 0;
    }

    public static Product getProductWithID(String productID) {
        for (Product product : allProducts) {
            if (product.productID.equals(productID)) {
                return product;
            }
        }
        return null;
    }

    public static boolean isThereProductWithID(String productID) {
        return getProductWithID(productID) != null;
    }

    public String toStringForCustomerView() {
        StringBuilder result = new StringBuilder();
        result.append("Name: ").append(this.name).append("\n");
        result.append("Brand: ").append(this.brand).append("\n");
        result.append("Description: ").append(this.description).append("\n");
        result.append("Sellers: " + "\n");
        for (String salesmanID : salesmanIDs) {
            if (!doesSalesmanSellProductWithUsername(salesmanID) || !isAvailableBySalesmanWithUsername(salesmanID)) {
                continue;
            }
            result.append("Salesman: ").append(salesmanID);
            result = new StringBuilder(" Price: " + price.get(salesmanID) + "\n");
        }
        return result.toString();
    }

    public String createID() {
        return RandomString.createID("Product");
    }
}
