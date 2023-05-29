package com.adi.Models;

/**
 Clasa "ClientModel" reprezintă o reprezentare a entității client în cadrul aplicației. Aceasta conține câmpurile și metodele necesare pentru gestionarea informațiilor despre un client.
 Principalele caracteristici ale clasei "ClientModel" sunt următoarele:
 Variabilele membru:
 name: reprezintă numele clientului (de tip String).
 email: reprezintă adresa de email a clientului (de tip String).
 address: reprezintă adresa clientului (de tip String).
 clientID: reprezintă ID-ul unic al clientului (de tip int).
 Metoda toString(): returnează o reprezentare sub formă de șir de caractere a obiectului "ClientModel", care include ID-ul, numele, adresa și adresa de email a clientului.
 Constructori:
 ClientModel(): construieste un obiect "ClientModel" fără a seta inițial nicio valoare pentru variabilele membru.
 ClientModel(int id, String name, String email, String address): construieste un obiect "ClientModel" cu valorile specificate pentru ID, nume, adresa și adresa de email.
 Metodele accesori și mutatoare (getters și setters):
 Metodele getClientID(), getName(), getAddress(): returnează valorile corespunzătoare pentru ID-ul clientului, nume și adresă.
 Metodele setClientID(), setName(), setAddress(): setează valorile corespunzătoare pentru ID-ul clientului, nume și adresă.
 Această clasă servește ca o structură de date pentru a stoca informațiile despre un client și pentru a facilita manipularea acestora în cadrul aplicației.

 */
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
