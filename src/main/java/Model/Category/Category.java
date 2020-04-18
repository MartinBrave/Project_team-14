package Model.Category;

import Model.RandomString;

import java.util.ArrayList;
import java.io.*;

public class Category extends RandomString implements Serializable {
    private ArrayList<String> allProductIDs;
    private String categoryID;
    private String parentCategoryID;
    private ArrayList<String> childCategoryIDs;
    private String attribute;

    @Override
    public String createID() {
        String result = "";
        result += "Category---";
        result += getRandomString();
        return result;
    }
}
