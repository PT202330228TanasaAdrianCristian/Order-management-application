package com.adi.Views;

import java.awt.Container;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.adi.Models.ClientModel;
import com.adi.Models.ProductModel;

public class OrdersDialog extends JDialog{
    
    JMenu viewMenu;
    JMenu insertMenu;

    JLabel clientIDLabel;
    JLabel productIDLabel;
    JLabel productQuantityLabel;

    JTextField clientIDTextField;
    JTextField productIDTextField;
    JTextField productQuantityTextField;

    JList<ClientModel> jlistClients;
    JList<ProductModel> jlistProducts;

    JButton submit;
    public OrdersDialog()
    {
        Container pane = this.getContentPane();

        submit = new JButton("Insert order");
        viewMenu = new JMenu("View");
        insertMenu = new JMenu("Insert");

        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(insertMenu);
        jMenuBar.add(viewMenu);
        this.setJMenuBar(jMenuBar);
        clientIDTextField = new JTextField();
        productIDTextField = new JTextField();
        productQuantityTextField = new JTextField();
        clientIDTextField.setBounds(100, 0, 100, 50);
        productIDTextField.setBounds(100, 50, 100, 50);
        productQuantityTextField.setBounds(100, 100, 100, 50);
        
        submit.setBounds(100, 150, 100, 50);

        clientIDLabel = new JLabel("Client ID");
        productIDLabel = new JLabel("Product ID");
        productQuantityLabel = new JLabel("Quantity");
        clientIDLabel.setBounds(0, 0, 100, 50);
        productIDLabel.setBounds(0, 50, 100, 50);
        productQuantityLabel.setBounds(0, 100, 100, 50);

        pane.add(clientIDTextField);
        pane.add(productIDTextField);
        pane.add(productQuantityTextField);
        pane.add(clientIDLabel);
        pane.add(productIDLabel);
        pane.add(productQuantityLabel);

        viewMenu.addMenuListener(new MenuListener() {

            @Override
            public void menuCanceled(MenuEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void menuSelected(MenuEvent e) {
                pane.removeAll();
                pane.add(jlistClients);
                pane.add(jlistProducts);
                repaint();
                
            }
            
        });

        insertMenu.addMenuListener(new MenuListener() {

            @Override
            public void menuCanceled(MenuEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void menuSelected(MenuEvent e) {
                // TODO Auto-generated method stub
                pane.removeAll();
                pane.add(clientIDTextField);
                pane.add(productIDTextField);
                pane.add(productQuantityTextField);
                pane.add(clientIDLabel);
                pane.add(productIDLabel);
                pane.add(productQuantityLabel);   
                pane.add(submit);
   
                pane.repaint();
            }
            
        });


        pane.add(submit);
    }

    public void setClients(List<ClientModel> lstClients)
    {
        jlistClients = new JList<ClientModel>(lstClients.toArray(new ClientModel[lstClients.size()]));
        jlistClients.setBounds(0, 0, 500, 1000);
    }

    public void setProducts(List<ProductModel> lstProducts)
    {
        jlistProducts = new JList<ProductModel>(lstProducts.toArray(new ProductModel[lstProducts.size()]));
        jlistProducts.setBounds(500, 0, 500, 1000);
    }

    public JButton getButtomSubmitCreate()
    {
        return submit;
    }
    

    public int getClientID()
    {
        return Integer.parseInt(clientIDTextField.getText());
    }

    public int getProductID()
    {
        return Integer.parseInt(productIDTextField.getText());
    }

    public int getProductQuantity()
    {
        return Integer.parseInt(productQuantityTextField.getText());
    }
}
