package infoplat.demo.daoImpl;

import infoplat.demo.dao.Dao;
import infoplat.demo.utils.DataSourcesManager;
import infoplat.demo.utils.JDBCUtils;
import infoplat.demo.utils.ReflectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Kael
 */
public class Daoimpl implements Dao {
    @Override
    public void update(String sql, Object... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = DataSourcesManager.getConnection();
            preparedStatement = JDBCUtils.getPreparedStatement(Objects.requireNonNull(connection),sql);
            for (int i = 0;i < args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(null,preparedStatement,connection);
        }
    }

    /**
     * 获取对象
     */
    @Override
    public <T> T get(Class<T> clazz, String sql, Object... args) {


        T entity = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DataSourcesManager.getConnection();
            preparedStatement = JDBCUtils.getPreparedStatement(Objects.requireNonNull(connection),sql);
            Map<String,Object> values = new HashMap<>();
            for (int i = 0;i < args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }

            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            while (resultSet.next()){
                for (int i = 0;i < rsmd.getColumnCount();i++){
                    String columnName = rsmd.getColumnName(i+1);
                    Object columnValue = resultSet.getObject(columnName);
                    values.put(columnName,columnValue);
                }
            }
            if (values.size()>0){
                //                通过反射创建对象
                entity = clazz.newInstance();
//              遍历Map
                for (Map.Entry<String,Object> entry:values.entrySet()){
                    String fieldName = entry.getKey();
                    Object fieldValues = entry.getValue();
                    ReflectionUtils.setFieldValue(entity,fieldName,fieldValues);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(resultSet,preparedStatement,connection);
        }
        return entity;
    }
}
