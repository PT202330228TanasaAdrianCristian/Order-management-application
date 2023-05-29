package com.adi.Views;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class CustomTableModel<T> implements TableModel {

    ArrayList<T> data;
    private final Class<T> type;
    ArrayList<Field> fields;

    @SuppressWarnings("unchecked")
    public CustomTableModel(List<T> data) {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.fields = new ArrayList<Field>();
        this.data = new ArrayList<>(data);
        for(Field field : type.getDeclaredFields())
        {
            fields.add(field);
        }
    }
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return fields.size();
    }

    @Override
    public String getColumnName(int i) {
        return fields.get(i).getName();
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return fields.get(i).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int col) {
        T valueAtRow = data.get(row);
        Field fieldAtCol = fields.get(col);

        Type fieldType = fieldAtCol.getType();
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldAtCol.getName(), type);
            Method readMethod = propertyDescriptor.getReadMethod();
            return readMethod.invoke(valueAtRow);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int row, int col) {
        T valueAtRow = data.get(row);
        Field fieldAtCol = fields.get(col);
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldAtCol.getName(), type);
            Method writeMethod = propertyDescriptor.getWriteMethod();
            writeMethod.invoke(valueAtRow, o);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {

    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {

    }
}
