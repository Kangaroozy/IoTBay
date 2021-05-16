  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.io.Serializable;

/**
 *
 * @author Reyvaldo
 */
public class Wishlist implements Serializable {

    private int wishlistID;
    private int userID;
    private int productID;

    public Wishlist(int wishlistID, int userID, int productID) {
        this.wishlistID = wishlistID;
        this.userID = userID;
        this.productID = productID;
    }

    public int getWishlistID() {
        return wishlistID;
    }

    public void setWishlistID(int wishlistID) {
        this.wishlistID = wishlistID;
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