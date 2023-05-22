package com.adi.Models;

public class ClientModel {
    
    private String name;
    private String email;
    private String address;
    private int clientID;


    public String toString()
    {
        return "ID = " + clientID + "Name = " + name + " Email = " + email + " Address = " + address;
    }
    public ClientModel()
    {
        clientID = -1;
        name = "";
        email = "";
        address = "";
    }

    public ClientModel(int id, String name, String email, String address)
    {
        this.clientID = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
