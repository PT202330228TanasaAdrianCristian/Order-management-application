package com.adi.Views;

import java.awt.Container;
import java.util.List;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.adi.Models.ClientModel;
import com.adi.Models.OrderModel;
import com.adi.Models.ProductModel;
/**
Clasa “OrdersDialog” este o fereastră de dialog care permite utilizatorului să introducă o comandă nouă în aplicație. Aceasta extinde clasa JDialog și conține elementele de interfață utilizator și logica asociată.
    Atributele clasei includ:
    Meniurile viewMenu și insertMenu pentru afișarea/opțiunile vizuale și inserarea de comenzi.
    Etichetele clientIDLabel, productIDLabel și productQuantityLabel care afișează etichetele corespunzătoare câmpurilor de introducere.
    Câmpurile de text clientIDTextField, productIDTextField și productQuantityTextField în care utilizatorul poate introduce informațiile necesare pentru comandă.
    Lista jlistClients și jlistProducts care afișează clienții și produsele disponibile în aplicație.
    Butonul submit care permite utilizatorului să introducă comanda.
*/
public class OrdersDialog extends JDialog{

    JMenu viewMenu;
    JMenu insertMenu;

    JMenu ordersMenu;


    JLabel clientIDLabel;
    JLabel productIDLabel;
    JLabel productQuantityLabel;

    JTextField clientIDTextField;
    JTextField productIDTextField;
    JTextField productQuantityTextField;
    public final int textAreaWidth = 100;
    public final int textAreaHeight = 50;
    public final int labelWidth = 100;
    public final int labelHeight = 50;

    JButton submit;

    ClientTableModel tableModelClients;
    ProductTableModel tableModelProducts;

    OrdersTableModel tableModelOrders;

    JTable tableClients;
    JTable tableProducts;

    JTable tableOrders;

    JScrollPane scrollPaneClients;
    JScrollPane scrollPaneProducts;

    JScrollPane scrollPaneOrders;


    public JMenu getViewMenu() { return viewMenu; };

    public JMenu getViewOrders() {return ordersMenu;};
    public OrdersDialog()
    {
        Container pane = this.getContentPane();

        submit = new JButton("Insert order");
        viewMenu = new JMenu("View");
        insertMenu = new JMenu("Insert");
        ordersMenu = new JMenu("Orders");

        scrollPaneClients = new JScrollPane();
        scrollPaneProducts = new JScrollPane();
        scrollPaneOrders = new JScrollPane();
        tableClients = new JTable();
        tableProducts = new JTable();
        tableOrders = new JTable();

        scrollPaneClients.setBounds(0, 0, 250, 500);
        scrollPaneProducts.setBounds(250, 0, 250, 500);
        scrollPaneOrders.setBounds(0, 0, 500, 500);
        tableClients.setBounds(0, 0, 250, 500);
        tableProducts.setBounds(0, 0, 250, 500);
        tableOrders.setBounds(0, 0, 500, 500);

        scrollPaneClients.setViewportView(tableClients);
        scrollPaneProducts.setViewportView(tableProducts);
        scrollPaneOrders.setViewportView(tableOrders);


        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(insertMenu);
        jMenuBar.add(viewMenu);
        jMenuBar.add(ordersMenu);

        this.setJMenuBar(jMenuBar);
        clientIDTextField = new JTextField();
        productIDTextField = new JTextField();
        productQuantityTextField = new JTextField();
        clientIDTextField.setBounds(labelWidth, 0, textAreaWidth, textAreaHeight);
        productIDTextField.setBounds(labelWidth, textAreaHeight, textAreaWidth, textAreaHeight);
        productQuantityTextField.setBounds(labelWidth, textAreaHeight * 2, textAreaWidth, textAreaHeight);

        submit.setBounds(100, 150, 150, 50);

        clientIDLabel = new JLabel("Client ID");
        productIDLabel = new JLabel("Product ID");
        productQuantityLabel = new JLabel("Quantity");
        clientIDLabel.setBounds(0, 0, labelWidth, labelHeight);
        productIDLabel.setBounds(0, labelHeight, labelWidth, labelHeight);
        productQuantityLabel.setBounds(0, labelHeight * 2, labelWidth, labelHeight);

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
                pane.add(scrollPaneProducts);
                pane.add(scrollPaneClients);
                repaint();

            }

        });

        ordersMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent menuEvent) {
                pane.removeAll();
                pane.add(scrollPaneOrders);
                repaint();
            }

            @Override
            public void menuDeselected(MenuEvent menuEvent) {

            }

            @Override
            public void menuCanceled(MenuEvent menuEvent) {

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
        pane.add(new JLabel("Orders"));
    }

    public void setClients(List<ClientModel> lstClients)
    {
        tableModelClients = new ClientTableModel(lstClients);
        tableClients.setModel(tableModelClients);
        repaint();
    }

    public void setProducts(List<ProductModel> lstProducts)
    {
        tableModelProducts = new ProductTableModel(lstProducts);
        tableProducts.setModel(tableModelProducts);
        repaint();
    }


    public void setOrders(List<OrderModel> lstOrders)
    {
        tableModelOrders = new OrdersTableModel(lstOrders);
        tableOrders.setModel(tableModelOrders);
        repaint();
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
