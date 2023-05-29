package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import com.adi.Models.ClientModel;
import com.adi.Models.OrderModel;
import com.adi.Models.ProductModel;

import DatabaseConnection.ClientDAO;
import DatabaseConnection.OrderDAO;
import DatabaseConnection.ProductDAO;


/**
 Clasa  "BusinessLogic" reprezintă o componentă care conține logica de afaceri pentru operațiile legate de manipularea datelor din tabelele "Clients", "Products" și "Orders". Aceasta utilizează obiecte DAO (Data Access Object) pentru a interacționa cu baza de date și a executa operațiile corespunzătoare.
 Principalele operații definite în clasa "BusinessLogic" sunt următoarele:
 -Operații pe tabela "Clients":
 getClients(): Returnează o listă de obiecte "ClientModel" reprezentând toți clienții din baza de date.
 editClient(ClientModel aModel): Actualizează informațiile unui client existent pe baza obiectului "ClientModel" furnizat.
 getClient(int clientID): Returnează un obiect "ClientModel" pentru un anumit client identificat prin ID (în acest caz, returnează întotdeauna null).
 insertClient(ClientModel clientModel): Inserează un nou client în baza de date utilizând obiectul "ClientModel" furnizat.
 deleteClient(int id): Șterge un client existent din baza de date pe baza ID-ului său.
 -Operații pe tabela "Products":
 getProducts(): Returnează o listă de obiecte "ProductModel" reprezentând toate produsele din baza de date.
 deleteProduct(int id): Șterge un produs existent din baza de date pe baza ID-ului său.
 addProduct(ProductModel aProduct): Adaugă un nou produs în baza de date utilizând obiectul "ProductModel" furnizat.
 editProduct(ProductModel aProduct): Actualizează informațiile unui produs existent pe baza obiectului "ProductModel" furnizat.
 -Operații pe tabela "Orders":
 getOrders(): Returnează o listă de obiecte "OrderModel" reprezentând toate comenzile din baza de date (în acest caz, returnează întotdeauna null).
 insertOrder(OrderModel order): Inserează o nouă comandă în baza de date utilizând obiectul "OrderModel" furnizat. De asemenea, actualizează cantitatea disponibilă a produsului corespunzător comenzii în tabelul "Products".

 */
public class BusinessLogic {

    //Operations to be performed on the Clients table
    public List<ClientModel> getClients()
    {
        ClientDAO clientDAO = new ClientDAO();
        List<ClientModel> lstClients = clientDAO.selectAll();
        return lstClients;
    }
    public boolean editClient(ClientModel aModel)
    {
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.update(aModel);
        return true;
    }
    public ClientModel getClient(int clientID)
    {
        return null;
    }

    public boolean insertClient(ClientModel clientModel)
    {
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.insert(clientModel);
        return true;
    }

    public boolean deleteClient(int id)
    {
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.deleteById(id);
        return true;
    }

    //Operations to be performed on the Products table

    public List<ProductModel> getProducts()
    {
        ProductDAO productDAO = new ProductDAO();

        return productDAO.selectAll();
    }

    public boolean deleteProduct(int id)
    {
        ProductDAO productDAO = new ProductDAO();
        productDAO.deleteById(id);
        return true;
    }

    public boolean addProduct(ProductModel aProduct)
    {
        ProductDAO productDAO = new ProductDAO();
        productDAO.insert(aProduct);
        return true;
    }

    //Operations to be performed on the Orders table
    public List<OrderModel> getOrders()
    {
        OrderDAO orderDAO = new OrderDAO();
        return orderDAO.selectAll();
    }

    public boolean insertOrder( OrderModel order)
    {
        ProductDAO productDAO = new ProductDAO();
        ProductModel aProductModel = productDAO.findById(order.productID);

        if(aProductModel.quantity < order.productQuantity)
        {
            return false;
        }
        aProductModel.setQuantity(aProductModel.getQuantity() - order.productQuantity);
        productDAO.update(aProductModel);
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.insert(order);
        return true;
    }

    public boolean editProduct( ProductModel aProduct)
    {
        ProductDAO productDAO = new ProductDAO();
        productDAO.update(aProduct);
        return true;
    }
}
