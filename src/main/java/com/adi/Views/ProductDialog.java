package com.adi.Views;

import java.awt.Container;
import java.util.List;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.adi.Models.ProductModel;

public class ProductDialog extends JDialog{


    public JButton buttonOpenCreate;
    public JButton buttonOpenEdit;
    public JButton buttonOpenDelete;

    public JTextField titleCreateTextField;
    public JTextField descriptionCreateTextField;
    public JTextField priceCreateTextField;
    public JTextField quantityCreateTextField;
    public JButton submitCreateButton;

    public JTextField idEditTextField;
    public JTextField quantityEditTextField;
    public JTextField titleEditTextField;
    public JTextField descriptionEditTextField;
    public JTextField priceEditTextField;
    public JButton submitEditButton;

    public JButton submitDeleteButton;

    public JLabel titleLabel;
    public JLabel descriptionLabel;
    public JLabel priceLabel;
    public JLabel idLabel;

    public JMenuBar menuBar;
    public JMenu viewMenu;

    public CustomTableModel<ProductModel> tableProductModel;

    public JScrollPane scrollPane;

    public JTable tableProducts;

    public final int textAreaWidth = 100;
    public final int textAreaHeight = 50;
    public final int labelWidth = 100;
    public final int labelHeight = 50;

    public JMenu getViewMenu() { return viewMenu; }

    public void setProducts(List<ProductModel> lstProducts)
    {
        tableProductModel = new ProductTableModel(lstProducts);
        tableProducts.setModel(tableProductModel);
        this.repaint();
    }

    public JButton getButtonSubmitCreate() {
        return submitCreateButton;
    }

    public JButton getButtonSubmitDelete() {
        return submitDeleteButton;
    }

    public JButton getButtonSubmitEdit() {
        return submitEditButton;
    }

    public int getIDEdit() {
        return Integer.parseInt(idEditTextField.getText());
    }
    public String getTitleEdit() {
        return titleEditTextField.getText();
    }

    public String getDescriptionEdit() {
        return descriptionEditTextField.getText();
    }

    public Float getPriceEdit() {
        return Float.parseFloat(priceEditTextField.getText());
    }

    public String getTitleCreate() {
        return titleCreateTextField.getText();
    }

    public String getDescriptionCreate() {
        return descriptionCreateTextField.getText();
    }

    public Float getPriceCreate() {
        return Float.parseFloat(priceCreateTextField.getText());
    }

    public int getQuantityCreate() {
        return Integer.parseInt(quantityCreateTextField.getText());
    }

    public int getQuantityEdit() {
        return Integer.parseInt(quantityEditTextField.getText());
    }
    /*
     * Press on the menu item and dynamically create the buttons and inputs for each operation
     *
     *  Clicking on openCreate will add to the contentPane all the elements neccesary for completing a createOperation, openEdit will add the edit componentsm, etc...
     */

    public ProductDialog()
    {
        Container pane = getContentPane();

        submitCreateButton = new JButton("Create"); //de pus set bounds si pt celelalte ferestre
        submitDeleteButton = new JButton("Delete");
        submitDeleteButton.setBounds(100,100, textAreaWidth, textAreaHeight);
        submitEditButton = new JButton("Edit");

        tableProducts = new JTable();
        scrollPane = new JScrollPane();

        tableProducts.setBounds(0,0, 500, 500);
        scrollPane.setBounds(0, 0, 500, 500);

        scrollPane.setViewportView(tableProducts);

        //Menu bar
        menuBar = new JMenuBar();
        JMenu createMenu = new JMenu("Create");
        JMenu editMenu = new JMenu("Edit");
        JMenu deleteMenu = new JMenu("Delete");
        viewMenu = new JMenu("View");

        menuBar.add(createMenu);
        menuBar.add(editMenu);
        menuBar.add(deleteMenu);
        menuBar.add(viewMenu);

        this.setJMenuBar(menuBar);

        titleCreateTextField = new JTextField();
        descriptionCreateTextField = new JTextField();
        priceCreateTextField = new JTextField();
        quantityCreateTextField = new JTextField();
        submitCreateButton = new JButton("Submit create");

        titleCreateTextField.setBounds(labelWidth, 0, textAreaWidth, textAreaHeight);
        descriptionCreateTextField.setBounds(labelWidth, textAreaHeight, textAreaWidth, textAreaHeight);
        priceCreateTextField.setBounds(labelWidth, textAreaHeight * 2, textAreaWidth, textAreaHeight);
        quantityCreateTextField.setBounds(labelWidth, textAreaHeight * 3, textAreaWidth, textAreaHeight);
        submitCreateButton.setBounds(labelWidth, textAreaHeight * 4, textAreaWidth, textAreaHeight);


        titleEditTextField = new JTextField();
        descriptionEditTextField = new JTextField();
        priceEditTextField = new JTextField();
        quantityEditTextField = new JTextField();
        submitEditButton = new JButton("Submit edit");
        idEditTextField = new JTextField();

        titleEditTextField.setBounds(labelWidth, 0, textAreaWidth, textAreaHeight);
        descriptionEditTextField.setBounds(labelWidth, textAreaHeight, textAreaWidth, textAreaHeight);
        priceEditTextField.setBounds(labelWidth, textAreaHeight * 2, textAreaWidth, textAreaHeight);
        quantityEditTextField.setBounds(labelWidth, textAreaHeight * 3, textAreaWidth, textAreaHeight);
        idEditTextField.setBounds(labelWidth, textAreaHeight * 4, textAreaWidth, textAreaHeight);
        submitEditButton.setBounds(labelWidth, textAreaHeight * 5, textAreaWidth, textAreaHeight);



        titleLabel = new JLabel("title");
        descriptionLabel = new JLabel("description");
        priceLabel = new JLabel("price");
        idLabel = new JLabel(" ID");
        JLabel quantityLabel = new JLabel("Quantity");

        titleLabel.setBounds(0, 0, labelWidth, labelHeight);
        descriptionLabel.setBounds(0, labelHeight, labelWidth, labelHeight);
        priceLabel.setBounds(0, labelHeight * 2, labelWidth, labelHeight);
        quantityLabel.setBounds(0, labelHeight * 3, labelWidth, labelHeight);
        idLabel.setBounds(0, labelHeight * 4, labelWidth, labelHeight);


        createMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                Container pane = getContentPane();
                pane.removeAll(); //Delete all the elements

                pane.add(titleCreateTextField);
                pane.add(descriptionCreateTextField);
                pane.add(priceCreateTextField);
                pane.add(submitCreateButton);
                pane.add(quantityCreateTextField);

                pane.add(titleLabel);
                pane.add(descriptionLabel);
                pane.add(priceLabel);
                pane.add(quantityLabel);
                //Add items for create
                repaint();
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                // TODO Auto-generated method stub
            }
        });

        editMenu.addMenuListener(new MenuListener() {

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
                Container pane = getContentPane();
                pane.removeAll(); //Delete all the elements

                pane.add(titleEditTextField);
                pane.add(descriptionEditTextField);
                pane.add(priceEditTextField);
                pane.add(submitEditButton);
                pane.add(idEditTextField);
                pane.add(quantityEditTextField);

                pane.add(titleLabel);
                pane.add(descriptionLabel);
                pane.add(priceLabel);
                pane.add(quantityLabel);
                pane.add(idLabel);

                //Add items for create
                repaint();
            }
        });

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
                // TODO Auto-generated method stub
                pane.removeAll();
                pane.add(scrollPane);
                repaint();
            }

        });

        deleteMenu.addMenuListener(new MenuListener() {

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
                pane.add(idEditTextField);
                pane.add(idLabel);
                pane.add(submitDeleteButton);
                pane.repaint();
            }

        });

    }
}
