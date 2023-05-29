package com.adi.Views;

import com.adi.Models.ClientModel;

import java.util.List;

public class ClientTableModel extends CustomTableModel<ClientModel>{

    public ClientTableModel(List<ClientModel> data) {
        super(data);
    }
}
