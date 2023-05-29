package com.adi.Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.adi.Models.ClientModel;

/**
 * Clasa "ClientDialog" este o clasă de vizualizare (view) în cadrul unei aplicații. Aceasta extinde clasa "JDialog" din biblioteca Swing și reprezintă o fereastră de dialog pentru interacțiunea cu informațiile despre clienți.
 * Principalele elemente ale clasei "ClientDialog" sunt următoarele:
 * Butoanele:
 * buttonOpenCreate, buttonOpenEdit, buttonOpenDelete: reprezintă butoane pentru deschiderea ferestrelor de creare, editare și ștergere a clienților.
 * Câmpurile de text:
 * emailCreateTextField, nameCreateTextField, addressCreateTextField: reprezintă câmpuri de text pentru introducerea informațiilor despre un nou client în procesul de creare.
 * idEditTextField, emailEditTextField, nameEditTextField, addressEditTextField: reprezintă câmpuri de text pentru introducerea informațiilor despre un client existent în procesul de editare.
 */


public class ClientDialog extends JDialog{

    public JMenu viewMenu;

    public CustomTableModel<ClientModel> tableModel;

    public JButton buttonOpenCreate;
    public JButton buttonGetClientById;

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

    public JScrollPane scrollPane;

    public final int textAreaWidth = 100;
    public final int textAreaHeight = 50;
    public final int labelWidth = 100;
    public final int labelHeigh = 50;

    public JTable tableClients;
    public void setClients(List<ClientModel> clients)
    {
        tableModel = new ClientTableModel(clients);
        tableClients.setModel(tableModel);
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

    public JMenu getMenuView() { return viewMenu;}

    public JMenuBar menuBar;
    /*
     * Press on the menu item and dynamically create the buttons and inputs for each operation
     *
     *  Clicking on openCreate will add to the contentPane all the elements neccesary for completing a createOperation, openEdit will add the edit componentsm, etc...
     */

    public ClientDialog()
    {
        Container pane = getContentPane();

        scrollPane = new JScrollPane();
        tableClients = new JTable();
        tableClients.setBounds(0,0, 500, 500);
        scrollPane.setBounds(0, 0, 500, 500);

        scrollPane.setViewportView(tableClients);

        buttonOpenCreate = new JButton("Tesin this shit");
        buttonOpenCreate.setBounds(0, 0, 50, 50);

        submitEditButton = new JButton("Edit");
        submitDeleteButton = new JButton("Delete");
        submitDeleteButton.setBounds(100,100, 150, 50);

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


        emailCreateTextField = new JTextField();
        nameCreateTextField = new JTextField();
        addressCreateTextField = new JTextField();
        submitCreateButton = new JButton("Create");

        //Incepe sa desenzi de la demnsiunea label-ului (fiindca este in stanga text field-ului)
        emailCreateTextField.setBounds(labelWidth, 0, textAreaWidth, textAreaHeight);
        nameCreateTextField.setBounds(labelWidth, textAreaHeight, textAreaWidth, textAreaHeight);
        addressCreateTextField.setBounds(labelWidth, textAreaHeight * 2, textAreaWidth, textAreaHeight);
        submitCreateButton.setBounds(labelWidth, textAreaHeight * 3, textAreaWidth, textAreaHeight);

        idEditTextField = new JTextField();
        emailEditTextField = new JTextField();
        nameEditTextField = new JTextField();
        addressEditTextField = new JTextField();
        submitEditButton = new JButton("Edit");


        emailEditTextField.setBounds(labelWidth, 0, textAreaWidth, textAreaHeight);
        nameEditTextField.setBounds(labelWidth, textAreaHeight, textAreaWidth, textAreaHeight);
        addressEditTextField.setBounds(labelWidth, textAreaHeight * 2, textAreaWidth, textAreaHeight);
        idEditTextField.setBounds(labelWidth, textAreaHeight * 3, textAreaWidth, textAreaHeight);
        submitEditButton.setBounds(labelWidth, textAreaHeight * 4, textAreaWidth, textAreaHeight);

        emailLabel = new JLabel("Email");
        nameLabel = new JLabel("Name");
        addressLabel = new JLabel("Address");
        idLabel = new JLabel("ID");

        emailLabel.setBounds(0, 0, labelWidth, labelHeigh);
        nameLabel.setBounds(0, labelHeigh, labelWidth, labelHeigh);
        addressLabel.setBounds(0, labelHeigh * 2, labelWidth, labelHeigh);
        idLabel.setBounds(0, labelHeigh * 3, labelWidth, labelHeigh);

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
                pane.add(scrollPane);
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
                pane.add(idLabel);
                pane.add(submitDeleteButton);
                pane.repaint();
            }

        });

    }
}
