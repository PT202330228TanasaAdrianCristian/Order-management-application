package com.adi.Views;

import com.adi.Models.ProductModel;

import java.util.List;

public class ProductTableModel extends CustomTableModel<ProductModel> {
    public ProductTableModel(List<ProductModel> data) {
        super(data);
    }
}
