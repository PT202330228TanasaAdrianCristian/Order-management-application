package com.adi.Models;


public class OrderModel {
    public int clientID;
    public int productID;
    public int productQuantity;
    public int orderID;

    public OrderModel(int orderID, int clientID, int productID, int productQuantity)
    {
        this.orderID = orderID;
        this.clientID = clientID;
        this.productID = productID;
        this.productQuantity = productQuantity;
    }


    public int getClientID() { return clientID; }
    public int getProductID() { return productID; }
    public int getProductQuantity() { return productQuantity; }
    public int orderID() { return orderID; }

    public void setClientID(int clientID) { this.clientID = clientID; }
    public void setProductID(int productID) { this.productID = productID; }
    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }
    
}
