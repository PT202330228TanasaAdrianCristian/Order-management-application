package DatabaseConnection;

import com.adi.Models.OrderModel;

public class OrderDAO extends AbstractDAO<OrderModel>{

    @Override
    protected String getIdColumnName() {
        return "orderID";
    }
    
}
