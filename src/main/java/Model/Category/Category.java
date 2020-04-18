package Model.Category;

import Model.RandomString;

import java.util.ArrayList;
import java.io.*;

public class Category implements Serializable, RandomString {
    private ArrayList<String> allProductIDs;
    private String categoryID;
    private String parentCategoryID;
    private ArrayList<String> childCategoryIDs;
    private String attribute;

    @Override
    public String createID() {
        return null;
    }
}
