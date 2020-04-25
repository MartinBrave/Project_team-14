package Model.Product;

import Model.RandomString;

import java.io.Serializable;

import static Model.Storage.*;

public class Point extends RandomString implements Serializable {
    private String pointID;
    private String username;
    private String productID;
    private int point;

    public Point(String username, String productID, int point) {
        this.username = username;
        this.point = point;
        this.productID = productID;
        allPoints.add(this);
        this.pointID = createID();
    }

    public static boolean isTherePointWithID(String pointID) {
        return getPointByID(pointID) != null;
    }

    public static Point getPointByID(String pointID) {
        for (Point point : allPoints) {
            if (point.pointID.equals(pointID)) {
                return point;
            }
        }
        return null;
    }

    public static boolean isTherePointForProduct(String productID) {
        return getAveragePointForProduct(productID) != -1;
    }

    public static float getAveragePointForProduct(String productID) {
        if (getNumberOfPeopleVotedForProduct(productID) == 0) {
            return -1;
        }
        int sum = 0;
        for (Point point : allPoints) {
            if (point.productID.equals(productID)) {
                sum += point.point;
            }
        }
        return (float) sum / (float) getNumberOfPeopleVotedForProduct(productID);
    }

    public static int getNumberOfPeopleVotedForProduct(String productID) {
        int numberOfPeopleVoted = 0;
        for (Point point : allPoints) {
            if (point.productID.equals(productID)) {
                numberOfPeopleVoted++;
            }
        }
        return numberOfPeopleVoted;
    }

    public String createID() {
        return RandomString.createID("Point");
    }

    public String getPointID() {
        return this.pointID;
    }


}
