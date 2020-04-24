package Model.Category;

import Model.Product.Product;
import Model.RandomString;

import java.util.ArrayList;
import java.io.*;

import static Model.Storage.*;

public class Category extends RandomString implements Serializable {

    //note that the name of each category must be unique so we can get the name
    //we should check to ensure that there's no previous category with this name
    private String categoryName;
    private ArrayList<String> allProductIDs = new ArrayList<>();
    private ArrayList<String> subCategoryNames = new ArrayList<>();
    private String parentCategoryName;
    private String attribute;

    public Category(String attribute, String parentCategoryName, String categoryName) {
        this.attribute = attribute;
        this.parentCategoryName = parentCategoryName;
        this.categoryName = categoryName;
        if (parentCategoryName != null) {
            getCategoryByName(parentCategoryName).addSubCategory(categoryName);
        }
        allCategories.add(this);
    }

    public Category getCategoryByName(String categoryName) {
        for (Category category : allCategories) {
            if (category.categoryName.equals(categoryName)) {
                return category;
            }
        }
        return null;
    }

    public void addProductToCategory(String productID) {
        this.allProductIDs.add(productID);
    }

    public boolean isThereCategoryWithName(String categoryName) {
        return getCategoryByName(categoryName) != null;
    }

    public void addSubCategory(String categoryName) {
        this.subCategoryNames.add(categoryName);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Category Name:").append(this.categoryName).append("\n");
        result.append("Category Attribute: ").append(this.attribute).append("\n");
        if (parentCategoryName == null) {
            result.append("The category doesn't have parent category" + "\n");
        } else {
            result.append("Parent Category: ").append(parentCategoryName).append("\n");
        }
        result.append("SubCategories: " + "\n");
        for (String subCategory : subCategoryNames) {
            result.append(subCategory).append("\n");
        }
        result.append("Products: " + "\n");
        for (String productID : allProductIDs) {
            result.append(Product.getNameByID(productID)).append("\n");
        }
        return result.toString();
    }

}
