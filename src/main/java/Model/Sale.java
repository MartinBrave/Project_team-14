package Model;

import java.util.ArrayList;

public class Sale extends Off {
    private static transient ArrayList allSaleIDs;
    private ArrayList productIDs;
    private String saleID;
    private String salesmanID;
    private String status;

    public boolean isSaleAuthentic(){
        return false;
    }

    public ArrayList getProductIDs(){
        return productIDs;
    }
}
