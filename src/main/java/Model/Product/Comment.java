package Model.Product;

import Model.Confirmation;
import Model.RandomString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Comment extends RandomString implements Serializable {
    private static transient ArrayList<Comment> allComments = new ArrayList<>();
    private String commentID;
    private String text;
    private String senderUsername;
    private String productID;
    private Confirmation confirmationState;
    private Date date;


    public Comment(String text, String senderUsername, String productID) {
        this.text = text;
        this.senderUsername = senderUsername;
        this.productID = productID;
        this.confirmationState = Confirmation.CHECKING;
        this.commentID = createID();
        this.date = new Date();
        allComments.add(this);
    }

    public static Comment getCommentByID(String commentID) {
        for (Comment comment : allComments) {
            if (comment.commentID.equals(commentID)) {
                return comment;
            }
        }
        return null;
    }

    //  when we need get comments for a product for customer view we use the method below

    public static ArrayList<String> getStringFormattedCommentsForProductWithID(String productID) {
        ArrayList<String> list = new ArrayList<>();
        for (Comment comment : allComments) {
            if (comment.isConfirmed() && comment.getCommentID().equals(productID)) {
                list.add(comment.toStringForProductView());
            }
        }
        return list;
    }

    //in the boss menu when the boss wants to check request one part is check comments
    //that are not still accpeted nor denied, so with moethod below we get not checked methods

    public static ArrayList<String> getStringFormattedCheckingComments() {
        ArrayList<String> list = new ArrayList<>();
        for (Comment comment : allComments) {
            if (comment.isChecking()) {
                list.add(comment.toStringForCheckingProduct());
            }
        }
        return list;
    }

    //it gives us customer view of a product

    public String toStringForProductView() {
        String result = "";
        result += "Sender: " + this.senderUsername + "\n";
        result += "message: " + this.text + "\n";
        result += "Date: " + this.date.toString() + "\n";
        return result;
    }

    //it gives us boss view for a product

    public String toStringForCheckingProduct() {
        String result = "";
        result += "Product Name: " + Product.getProductWithID(productID).getName();
        result += "Sender: " + this.senderUsername + "\n";
        result += "message: " + this.text + "\n";
        result += "Date: " + this.date.toString() + "\n";
        return result;
    }

    public static boolean isThereAnyCommentForProduct(String productID) {
        for (Comment comment : allComments) {
            if (comment.isConfirmed() && comment.productID.equals(productID)) {
                return true;
            }
        }
        return false;
    }

    public String getCommentID() {
        return commentID;
    }


    public boolean isConfirmed() {
        return confirmationState.equals(Confirmation.ACCEPTED);
    }

    public boolean isChecking() {
        return confirmationState.equals(Confirmation.CHECKING);
    }

    public String createID() {
        return RandomString.createID("Comment");
    }
}
