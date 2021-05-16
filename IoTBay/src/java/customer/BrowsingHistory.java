package customer;

import java.io.Serializable;

/**
 *
 * @author Reyvaldo
 */
public class BrowsingHistory implements Serializable{
    private int browsingID;
    private int userID;
    private int productID;

    public BrowsingHistory(int browsingID, int userID, int productID) {
        this.browsingID = browsingID;
        this.userID = userID;
        this.productID = productID;
    }

    public int getBrowsingID() {
        return browsingID;
    }

    public void setBrowsingID(int browsingID) {
        this.browsingID = browsingID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    
}