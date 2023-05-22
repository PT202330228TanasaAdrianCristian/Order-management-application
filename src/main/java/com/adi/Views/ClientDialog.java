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


public class ClientDialog extends JDialog{
    
    public JButton buttonOpenCreate;
    public JButton buttonOpenEdit;
    public JButton buttonOpenDelete;

    public JTextField emailCreateTextField;
    public JTextField nameCreateTextField;
    public JTextField addressCreateTextField;
    public JButton submitCreateButton;

    public JTextField idEditTextField;
    public JTextField emailEditTextField;
    public JTextField nameEditTextField;
    public JTextField addressEditTextField;
    public JButton submitEditButton;
 
    public JButton submitDeleteButton;

    public JLabel idLabel;
    public JLabel emailLabel;
    public JLabel nameLabel;
    public JLabel addressLabel;

    public JList<ClientModel> jlistClients;

    public void setClients(List<ClientModel> clients)
    {
        jlistClients = new JList<ClientModel>(clients.toArray(new ClientModel[clients.size()]));
        
    }

    //private int xCoordianteEmailInput;
    //private int yCoordinateEmailInput;
    //private int xNameEdi

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
    public String getEmailEdit() {
        return emailEditTextField.getText();
    }

    public String getNameEdit() {
        return nameEditTextField.getText();
    }

    public String getAddressEdit() {
        return addressEditTextField.getText();
    }

    public String getEmailCreate() {
        return emailCreateTextField.getText();
    }

    public String getNameCreate() {
        return nameCreateTextField.getText();
    }

    public String getAddressCreate() {
        return addressCreateTextField.getText();
    }

    public JMenuBar menuBar;
    /*
     * Press on the menu item and dynamically create the buttons and inputs for each operation
     *  
     *  Clicking on openCreate will add to the contentPane all the elements neccesary for completing a createOperation, openEdit will add the edit componentsm, etc...
     */

    public ClientDialog()
    {
        Container pane = getContentPane();

        buttonOpenCreate = new JButton("Tesin this shit");
        buttonOpenCreate.setBounds(0, 0, 50, 50);

        submitEditButton = new JButton("Edit");
        submitDeleteButton = new JButton("Delete");
        submitDeleteButton.setBounds(100,100, 50, 50);

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


        emailCreateTextField = new JTextField();
        nameCreateTextField = new JTextField();
        addressCreateTextField = new JTextField();
        submitCreateButton = new JButton("Create");

        emailCreateTextField.setBounds(100, 0, 50, 50);
        nameCreateTextField.setBounds(100, 50, 50, 50);
        addressCreateTextField.setBounds(100, 100, 50, 50);
        submitCreateButton.setBounds(100, 150, 50, 50);

        idEditTextField = new JTextField();
        emailEditTextField = new JTextField();
        nameEditTextField = new JTextField();
        addressEditTextField = new JTextField();
        submitEditButton = new JButton("Edit");


        emailEditTextField.setBounds(100, 0, 50, 50);
        nameEditTextField.setBounds(100, 50, 50, 50);
        addressEditTextField.setBounds(100, 100, 50, 50);
        submitEditButton.setBounds(100, 150, 50, 50);
        idEditTextField.setBounds(100, 200, 50 , 50);


        emailLabel = new JLabel("Email");
        nameLabel = new JLabel("Name");
        addressLabel = new JLabel("Address");
        idLabel = new JLabel("ID");

        emailLabel.setBounds(0, 0, 50, 50);
        nameLabel.setBounds(0, 50, 50, 50);
        addressLabel.setBounds(0, 100, 50, 50);
        idLabel.setBounds(0, 200, 50, 50);

        createMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuCanceled(MenuEvent e) {}
            @Override
            public void menuDeselected(MenuEvent e) {}
            @Override
            public void menuSelected(MenuEvent e) {
                Container pane = getContentPane();
                pane.removeAll(); //Delete all the elements
                
                pane.add(emailCreateTextField);
                pane.add(nameCreateTextField);
                pane.add(addressCreateTextField);
                pane.add(submitCreateButton);

                pane.add(emailLabel);
                pane.add(nameLabel);
                pane.add(addressLabel);
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
                jlistClients.setBounds(0, 0, 500, 500);
                pane.add(jlistClients);
                pane.repaint();
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
                
                pane.add(emailEditTextField);
                pane.add(nameEditTextField);
                pane.add(addressEditTextField);
                pane.add(submitEditButton);
                pane.add(idEditTextField);

                pane.add(emailLabel);
                pane.add(nameLabel);
                pane.add(addressLabel);
                pane.add(idLabel);
                //Add items for create 
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
