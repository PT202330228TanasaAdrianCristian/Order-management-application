package com.adi.Views;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;

import com.adi.Models.ClientModel;
import com.adi.Models.OrderModel;
import com.adi.Models.ProductModel;

import BusinessLogic.BusinessLogic;

import javax.swing.*;

public class MainWindow {

    public JFrame mainFrame;

    private BusinessLogic businessLogic;

    public JLabel clientWindowLabel;
    public JLabel productWindowLabel;
    public JLabel ordersWindowLabel;

    public JButton clientWindowButton;
    public JButton productWindowButton;
    public JButton ordersWindowButton;

    public JOptionPane clientOptionPane;
    public JOptionPane productOptionPane;
    public JOptionPane ordersOptionPane;

    public ClientDialog clientWindow;
    public ProductDialog productWindow;
    public OrdersDialog ordersWindow;


    public MainWindow() {
        businessLogic = new BusinessLogic();
        mainFrame = new JFrame("Project");
        clientWindow = new ClientDialog();
        productWindow = new ProductDialog();
        ordersWindow = new OrdersDialog();

        mainFrame.getContentPane();

        clientWindowLabel = new JLabel("Go to client window");
        productWindowLabel = new JLabel("Go to product window");
        ordersWindowLabel = new JLabel("Go to orders window");

        clientWindowButton = new JButton("Open client dialog");
        clientWindowButton.setBounds(25, 50, 50, 50);
        clientWindowButton.addActionListener(new ActionListener () {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    /*
                        Open a new ClientDialog (that's basically a new window that is connected to the parent)
                        while this window is opened, the main Frame will be disabled and not in focus.
                        This object handles the client operations
                    */
                    List<ClientModel> clientModelsInDatabase = businessLogic.getClients();
                    clientWindow.setClients(clientModelsInDatabase);
                    showMenu(clientWindow);
                }
                catch(Exception err)
                {
                    err.printStackTrace();
                }
            }
        });

        productWindowButton = new JButton("Product");
        productWindowButton.setBounds(0, 0, 50, 50);
        productWindowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ProductModel> lstProducts = businessLogic.getProducts();
                productWindow.setProducts(lstProducts);
                showMenu(productWindow);
            }
        });

        ordersWindowButton = new JButton("Orders");
        ordersWindowButton.setBounds(25, 150, 50, 50);
        ordersWindowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ClientModel> lstClients = businessLogic.getClients();
                List<ProductModel> lstProducts = businessLogic.getProducts();

                ordersWindow.setClients(lstClients);
                ordersWindow.setProducts(lstProducts);
                showMenu(ordersWindow);
            }
        });

        mainFrame.add(clientWindowButton);
        mainFrame.add(productWindowButton);
        mainFrame.add(ordersWindowButton);
        clientOptionPane = new JOptionPane();

        //button events to business logic connections

        //Add new client
        ActionListener createNewClientActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = clientWindow.getNameCreate();
                String email = clientWindow.getEmailCreate();
                String address = clientWindow.getAddressCreate();

                ClientModel aClientModel = new ClientModel(-1, name, email, address);

                //Poate trbuie try/catch?
                businessLogic.insertClient(aClientModel);

            }
        };

        clientWindow.getButtonSubmitDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int id = clientWindow.getIDEdit();
                businessLogic.deleteClient(id);

            }
        });

        clientWindow.getButtonSubmitCreate().addActionListener(createNewClientActionListener);

        //Edit client
        ActionListener editClientActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int id = clientWindow.getIDEdit();
                String name = clientWindow.getNameEdit();
                String address = clientWindow.getAddressEdit();
                String email = clientWindow.getEmailEdit();

                ClientModel edtClientModel = new ClientModel(id, name, email, address);

                businessLogic.editClient(edtClientModel);
            }
        };

        clientWindow.getButtonSubmitEdit().addActionListener(editClientActionListener);

        //Delete client
        ActionListener deleteClientActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int id = clientWindow.getIDEdit();
                businessLogic.deleteClient(id);
            }
        };
        clientWindow.getButtonSubmitDelete().addActionListener(deleteClientActionListener);


        productWindow.getButtonSubmitCreate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String title = productWindow.getTitleCreate();
                String description = productWindow.getDescriptionCreate();
                Float price = productWindow.getPriceCreate();
                int quantity = productWindow.getQuantityCreate();

                ProductModel newProductModel = new ProductModel(-1, title, price, description, quantity);

                businessLogic.addProduct(newProductModel);
            }
        });

        productWindow.getButtonSubmitDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int id = productWindow.getIDEdit();
                businessLogic.deleteProduct(id);
            }
        });

        productWindow.getButtonSubmitEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int productID = productWindow.getIDEdit();
                String title = productWindow.getTitleEdit();
                String description = productWindow.getDescriptionEdit();
                Float price = productWindow.getPriceEdit();
                int quantity = productWindow.getQuantityEdit();

                ProductModel edtProductModel = new ProductModel(productID, title, price, description, quantity);

                businessLogic.editProduct(edtProductModel);
            }
        });

        ordersWindow.getButtomSubmitCreate().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int clientID = ordersWindow.getClientID();
                int productID = ordersWindow.getProductID();
                int productQuantity = ordersWindow.getProductQuantity();

                OrderModel orderToInsert = new OrderModel(-1, clientID, productID, productQuantity);


                if(!businessLogic.insertOrder(orderToInsert)) //Can't buy quantity to buy > quantity on stock
                {
                    JOptionPane.showMessageDialog(mainFrame, "Error inserting order out of stock");
                }
            }
        });

        mainFrame.setBounds(500, 500, 500, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    };

    public void showMenu(JDialog menu)
    {
        menu.setModalityType(ModalityType.APPLICATION_MODAL);
        menu.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        menu.setBounds(0, 0, 1000, 1000);
        menu.setVisible(true);
        menu.repaint();
    }

}
