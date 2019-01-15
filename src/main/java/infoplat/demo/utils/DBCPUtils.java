package infoplat.demo.utils;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Kael
 */
public class DBCPUtils {
    private static Properties properties = new Properties();
    private static DataSource dataSource;

    static {
        try {
            FileInputStream is = new FileInputStream("D:\\java_study\\infoPlat\\src\\main\\resources\\jdbc.properties");
            properties.load(is);
            dataSource = BasicDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
