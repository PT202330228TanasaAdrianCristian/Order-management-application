package com.adi.Models;

public class ProductModel {
    
    public String title;
    public Float price;
    public String description;
    public int quantity;
    public int productID;

    public ProductModel()
    {
        this.title = "";
        this.price = 0.0f;
        this.description = "";
        this.quantity = 0;
        this.productID = -1;
    }

    public ProductModel(int id, String title, Float price, String description, int quantity)
    {
        this.productID = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public int getProductID() { return productID; }
    public String getTitle() { return title; }
    public Float getPrice() { return price; }
    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }

    public void setProductID(int productID) { this.productID = productID; }
    public void setTitle(String title) { this.title = title; }
    public void setPrice(Float price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String toString()
    {
        return "ID = " + productID + " Title = " + title + " Price = " + price + "Quant = " + quantity + " Description = " + description;
    }
}
