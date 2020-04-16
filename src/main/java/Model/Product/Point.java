package Model.Product;

import java.util.ArrayList;

public class Point {
    private ArrayList<Point> allPoints;
    private String pointID;
    private String username;
    private String productID;
    private int point;

    public static boolean isTherePointForProduct(String productID){
        return false;
    }

    public static float getAveragePointForProduct(String productID){
        return 0;
    }

    public static int getNumberOfPeopleVotedForProduct(String productID){
        return 0;
    }


}
