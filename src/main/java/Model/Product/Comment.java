package Model.Product;

import java.util.ArrayList;


enum confirmation {
    CHECKING, ACCEPTED, DENIED;
}


public class Comment {
    private static transient ArrayList<Comment> allComments = new ArrayList<>();
    private String commentID;
    private String text;
    private String senderUsername;
    private String productID;
    private confirmation confirmationState;


    public Comment(String text, String senderUsername, String productID) {
        this.text = text;
        this.senderUsername = senderUsername;
        this.productID = productID;
        this.confirmationState = confirmation.CHECKING;
        this.commentID = createID();
    }

    public static Comment getCommentByID(String commentID) {
        for (Comment comment : allComments) {
            if (comment.commentID.equals(commentID)) {
                return comment;
            }
        }
        return null;
    }

    public boolean isConfirmed() {
        return confirmationState.equals(confirmation.ACCEPTED);
    }

    public ArrayList<String> getStringFormattedCommentsForProductWithID(String productID){
      //  ArrayList<String>
        return null;
    }

    public String createID() {
        return null;
    }

}
