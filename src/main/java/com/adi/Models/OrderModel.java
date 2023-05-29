package com.adi.Models;

/** Clasa "OrderModel" reprezintă o reprezentare a entității comandă în cadrul aplicației. Aceasta conține variabilele și metodele necesare pentru gestionarea informațiilor despre o comandă.
    Principalele caracteristici ale clasei "OrderModel" sunt următoarele:
    Variabilele membru:
    clientID: reprezintă ID-ul clientului asociat comenzii (de tip int).
    productID: reprezintă ID-ul produsului asociat comenzii (de tip int).
    productQuantity: reprezintă cantitatea produsului comandat (de tip int).
    orderID: reprezintă ID-ul unic al comenzii (de tip int).
    Constructor:
    o	OrderModel(int orderID, int clientID, int productID, int productQuantity): construiește un obiect "OrderModel" cu valorile specificate pentru ID-ul comenzii, ID-ul clientului, ID-ul produsului și cantitatea produsului.
    Metodele accesori și mutatoare (getters și setters):
    Metodele getClientID(), getProductID(), getProductQuantity(), getOrderID(): returnează valorile corespunzătoare pentru ID-ul clientului, ID-ul produsului, cantitatea produsului și ID-ul comenzii.
    Metodele setClientID(), setProductID(), setProductQuantity(): setează valorile corespunzătoare pentru ID-ul clientului, ID-ul produsului și cantitatea produsului.
    Această clasă servește ca o structură de date pentru a stoca informațiile despre o comandă și pentru a facilita manipularea acestora în cadrul aplicației.
*/
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

    public OrderModel() {
        this.orderID = -1;
        this.clientID = -1;
        this.productID = -1;
        this.productQuantity = -1;
    }


    public int getClientID() { return clientID; }
    public int getProductID() { return productID; }
    public int getProductQuantity() { return productQuantity; }
    public int getOrderID() { return orderID; }

    public void setClientID(int clientID) { this.clientID = clientID; }
    public void setProductID(int productID) { this.productID = productID; }
    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }
    public void setOrderID(int orderID) { this.orderID = orderID;}

}
