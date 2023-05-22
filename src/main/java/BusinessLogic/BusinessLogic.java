package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import com.adi.Models.ClientModel;
import com.adi.Models.OrderModel;
import com.adi.Models.ProductModel;

import DatabaseConnection.ClientDAO;
import DatabaseConnection.OrderDAO;
import DatabaseConnection.ProductDAO;

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
    public ArrayList<OrderModel> getOrders()
    {
        return null;
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
