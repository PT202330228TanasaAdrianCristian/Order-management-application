package DatabaseConnection;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<T> {

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected abstract String getIdColumnName();

    private String createSelectAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());

        return sb.toString();
    }

    //SELECT fields FROM table_name WHERE condition
    private String createSelectQuery(String field)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " = ?");
        return sb.toString();
    }
    //DELETE FROM table_name WHERE condition;
    private String createDeleteQuery(String field)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(" DELETE FROM ");
        sb.append(type.getSimpleName()); //because table = className
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }
    /*
     *  UPDATE table_name
        SET column1 = value1, column2 = value2, ...
        WHERE condition;    
     */
    private String createUpdateQuery()
    {
        StringBuilder sb = new StringBuilder();
        Field[] fields = type.getDeclaredFields();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        for(int indexField = 0; indexField < fields.length - 1; indexField ++) {
            String fieldName = fields[indexField].getName();
            if(fieldName != getIdColumnName()) {
                sb.append(fieldName);
                sb.append(" = ?");
                if(indexField < fields.length - 2) //Fara ID
                {
                    sb.append(", ");
                }
            }
        }
        sb.append(" WHERE ");
        sb.append(getIdColumnName());
        sb.append(" = ? ");
        System.out.println(sb.toString());
        return sb.toString();
    }

    public int update(T itemToUpdate)
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery();
        try {
            connection = ConnectionFactory.getInstance().createConnection();
            statement = connection.prepareStatement(query);
            Field[] fields = type.getDeclaredFields();
            setStatementValues(statement, fields, itemToUpdate, true);
            System.out.println(statement.toString());
            return statement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return -1;
    }
/*
 * INSERT INTO table_name (column1, column2, column3, ...)
    VALUES (value1, value2, value3, ...);
 */
    private String createInsertQuery()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());

        Field[] fields = type.getDeclaredFields();
        sb.append(" ( ");
        int fieldIndex = 0;
        for(fieldIndex = 0; fieldIndex < fields.length - 1; fieldIndex++) 
        {
            Field field = fields[fieldIndex];
            if(field.getName() != getIdColumnName())
            {
                sb.append(field.getName());
                if(fieldIndex < fields.length - 2) {
                    sb.append(" , ");
                }
            }
        }
        sb.append(" ) ");
        sb.append(" VALUES ");

        sb.append(" ( ");
        for(int valueIndex = 0; valueIndex < fields.length - 2; valueIndex++) //-2 pt ca este coloana ID
        {
            sb.append(" ? ,");
        }
        sb.append(" ? ");
        sb.append(" ) ");
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void setStatementValues(PreparedStatement statement, Field[] fields, T itemToInsert, boolean isUpdateStatement) throws Exception
    {
        for(int fieldIndex = 0; fieldIndex < fields.length; fieldIndex ++ ) {
            Field field = fields[fieldIndex];
            String fieldName = field.getName();
            if(fieldName != getIdColumnName() || isUpdateStatement) {
                Type fieldType = field.getType();
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                Method readMethod = propertyDescriptor.getReadMethod();
                String fieldTypeClassName = fieldType.getTypeName();
                if(fieldTypeClassName == "java.lang.String") {
                    String value = (String)readMethod.invoke(itemToInsert);
                    statement.setString(fieldIndex + 1, value); 
                }

                if(fieldTypeClassName == "int") {
                    int value = (int)readMethod.invoke(itemToInsert);
                    statement.setInt(fieldIndex + 1, value);
                }

                if(fieldTypeClassName == "java.lang.Float") {
                    Float value = (Float)readMethod.invoke(itemToInsert);
                    statement.setFloat(fieldIndex + 1, value);
                }
            }
        }
    }

    public int insert(T itemToInsert) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createInsertQuery();
        try {
            connection = ConnectionFactory.getInstance().createConnection();
            statement = connection.prepareStatement(query);
            Field[] fields = type.getDeclaredFields();
            setStatementValues(statement, fields, itemToInsert, false);
            System.out.println(statement.toString());
            return statement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return 0;
    }

    public boolean deleteById(int id) 
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery(getIdColumnName()); //Trebuie sa faci rost de campul id...
        try {
            connection = ConnectionFactory.getInstance().createConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        
        return false;
    }

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery(getIdColumnName());
        try {
            connection = ConnectionFactory.getInstance().createConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id); //Blablabla ... WHERE Field = ? 
            //INSERT INTO ProductModel ( title , price , description )  VALUES  (  ? , 15.5 , ?  )
            /*
             * statement.setFloat(2, 15.5);
             */
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        
        return null;
    }

    public List<T> selectAll()
    {
        String selectAllQuery = createSelectAllQuery();
        System.out.println(selectAllQuery);
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getInstance().createConnection();
            statement = connection.prepareStatement(selectAllQuery);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } 
        catch( Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet)
    {
        List<T> list = new ArrayList<T>();

        try{
            while(resultSet.next()) {
                T instance = type.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    Object value = resultSet.getObject(field.getName());
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
