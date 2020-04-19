package Model.Category;

import Model.RandomString;

import java.util.ArrayList;
import java.io.*;

import static Model.Storage.*;

public class Category extends RandomString implements Serializable {
    private ArrayList<String> allProductIDs = new ArrayList<>();
    private ArrayList<String> subCategoryIDs = new ArrayList<>();
    private String categoryID;
    private String parentCategoryID;
    private String attribute;

    public Category(String attribute, String parentCategoryID) {
        this.attribute = attribute;
        this.parentCategoryID = parentCategoryID;
        this.categoryID = createID();
        if (parentCategoryID != null) {
            getCategoryByID(parentCategoryID).addSubCategory(this.categoryID);
        }
        allCategories.add(this);
    }

    public Category getCategoryByID(String categoryID) {
        for (Category category : allCategories) {
            if (category.categoryID.equals(categoryID)) {
                return category;
            }
        }
        return null;
    }

    public void addSubCategory(String categoryID){
        this.subCategoryIDs.add(categoryID);
    }

    public String toString(){
        return null;
    }

    public String createID() {
        return RandomString.createID("Category");
    }
}
