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

    public JList<ProductModel> jlistProducts;

    public JMenuBar menuBar;

    public void setProducts(List<ProductModel> lstProducts)
    {
        jlistProducts = new JList<ProductModel>(lstProducts.toArray(new ProductModel[lstProducts.size()]));
        jlistProducts.setBounds(0, 0, 500, 500);
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
        submitDeleteButton.setBounds(100,100, 50, 50);
        submitEditButton = new JButton("Edit");

        //Menu bar
        menuBar = new JMenuBar();
        JMenu createMenu = new JMenu("Create");
        JMenu editMenu = new JMenu("Edit");
        JMenu deleteMenu = new JMenu("Delete");
        JMenu viewMenu = new JMenu("View");
    
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

        titleCreateTextField.setBounds(100, 0, 50, 50);
        descriptionCreateTextField.setBounds(100, 50, 50, 50);
        priceCreateTextField.setBounds(100, 100, 50, 50);
        submitCreateButton.setBounds(100, 150, 50, 50);
        quantityCreateTextField.setBounds(100, 200, 50, 50);

        titleEditTextField = new JTextField();
        descriptionEditTextField = new JTextField();
        priceEditTextField = new JTextField();
        quantityEditTextField = new JTextField();
        submitEditButton = new JButton("Submit edit");
        idEditTextField = new JTextField();

        titleEditTextField.setBounds(100, 0, 50, 50);
        descriptionEditTextField.setBounds(100, 50, 50, 50);
        priceEditTextField.setBounds(100, 100, 50, 50);
        submitEditButton.setBounds(100, 150, 50, 50);
        idEditTextField.setBounds(150, 150, 50, 50);
        quantityEditTextField.setBounds(100, 200, 50, 50);


        titleLabel = new JLabel("title");
        descriptionLabel = new JLabel("description");
        priceLabel = new JLabel("price");
        JLabel quantityLabel = new JLabel("Quantity");

        titleLabel.setBounds(0, 0, 50, 50);
        descriptionLabel.setBounds(0, 50, 50, 50);
        priceLabel.setBounds(0, 100, 50, 50);
        quantityLabel.setBounds(0, 200, 50, 50);

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
                pane.add(jlistProducts);
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
                pane.add(submitDeleteButton);
                pane.repaint();
            }
            
        });
    
    }
}
