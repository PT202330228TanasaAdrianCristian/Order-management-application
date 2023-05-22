package DatabaseConnection;

import com.adi.Models.ClientModel;

public class ClientDAO extends AbstractDAO<ClientModel>{

    @Override
    protected String getIdColumnName() {
        return "clientID";
    }
    
}
