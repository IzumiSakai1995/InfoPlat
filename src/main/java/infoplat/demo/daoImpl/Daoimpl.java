package infoplat.demo.daoImpl;

import infoplat.demo.dao.Dao;
import infoplat.demo.utils.DataSourcesManager;
import infoplat.demo.utils.JDBCUtils;
import infoplat.demo.utils.ReflectionUtils;

import java.sql.*;
import java.util.*;

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
                    System.out.println(sql);
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

    @Override
    public List<Map<String, Object>> query(String sql) {
        Connection connection = DataSourcesManager.getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Map<String,Object>> list = new ArrayList<>();
            while(rs.next()){
                Map<String,Object> map = new LinkedHashMap<>();
                map.put("sName",rs.getObject(1));
                map.put("sTel",rs.getObject(2));
                map.put("dtInsert",rs.getObject(3));
                map.put("iInsertAdmin",rs.getObject(4));
                map.put("dtUpdate",rs.getObject(5));
                map.put("iUpdateAdmin",rs.getObject(6));
                map.put("iRoleId",rs.getObject(7));
                list.add(map);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
