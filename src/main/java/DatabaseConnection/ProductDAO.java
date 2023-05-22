package DatabaseConnection;

import com.adi.Models.ProductModel;

public class ProductDAO extends AbstractDAO<ProductModel>{

    @Override
    protected String getIdColumnName() {
        // TODO Auto-generated method stub
        return "productID";
    }
    
}
