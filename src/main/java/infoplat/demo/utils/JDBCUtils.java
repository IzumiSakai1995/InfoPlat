package infoplat.demo.utils;


import java.sql.*;

/**
 * @author Kael
 */
public class JDBCUtils {

    public static PreparedStatement getPreparedStatement(Connection connection, String sql) {
//        声明SQL命令发生器对象
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    /**
     * 执行SQL的方法
     *
     * @param sql: insert update 或者 delete ，不包含select;
     */
    public static void update(String sql) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtils.getConnection();


            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(statement, connection);
        }
    }

    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void release(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws Exception {

        return null;
    }
}
