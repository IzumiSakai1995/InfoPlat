package infoplat.demo.utils;


import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    public static PreparedStatement getPreparedStatement(Connection connection, String sql) {
//        声明SQL命令发生器对象
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =connection.prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    /**
    * 执行SQL的方法
    * @param sql: insert update 或者 delete ，不包含select;
    *
    * */
    public static void update(String sql){
        Connection connection = null;
        Statement statement =null;
        try {
            connection = JDBCUtils.getConnection();


            statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(statement,connection);
        }
    }
    public static void release(ResultSet resultSet, Statement statement, Connection connection){
        if (resultSet !=null){
            try {
                resultSet.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }

        if (connection != null){
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
    public static void release(Statement statement, Connection connection){
        if (statement != null){
            try {
                statement.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }

        if (connection != null){
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
    public static Connection getConnection() throws Exception {

//        1.准备连接数据库的4个字符串
//        驱动全类名

        String driverClass = null;
        String jdbcUrl =null;
        String user = null;
        String password = null;
//        读取jdbc.properties文件


//            InputStream in = new FileInputStream("jdbc.properties");

//        InputStream in = getClass().getClassLoader().getResourceAsStream("D:\\java_study\\JAVA_IO\\src\\jdbc.properties")

            Properties properties = new Properties();
            properties.load(in);
//        2.加载驱动程序(对应Driver类中有注册驱动的静态代码块)

            driverClass = properties.getProperty("driver");
            jdbcUrl = properties.getProperty("jdbcUrl");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(driverClass);
            in.close();
            //        3.获取数据库连接

//        DriverManager.registerDriver(driverClass); 造成DriverManager中产生两个一样的驱动，并会对具体的驱动类产生依赖
            return DriverManager.getConnection(jdbcUrl,user,password);
    }
}

