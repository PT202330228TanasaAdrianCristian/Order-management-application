package com.adi.Views;

import com.adi.Models.OrderModel;

import java.util.List;

public class OrdersTableModel extends CustomTableModel<OrderModel> {

    public OrdersTableModel(List<OrderModel> data) {
        super(data);
    }
}
