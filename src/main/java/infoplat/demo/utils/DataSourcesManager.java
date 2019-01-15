package infoplat.demo.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * @author Kael
 */
public class DataSourcesManager {

    private final static BasicDataSource DATA_SOURCE = new BasicDataSource();

    static {
        DATA_SOURCE.setDriverClassName("com.mysql.jdbc.Driver");
        DATA_SOURCE.setUrl("jdbc:mysql://10.25.194.117/user?serverTimezone=PRC&characterEncoding=utf-8&useSSL=true");
//		DATA_SOURCE.setDriverClassName("oracle.jdbc.OracleDriver");    //驱动标识符
//		DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521:XE"); //链接字符串

        DATA_SOURCE.setUsername("root");
//		DATA_SOURCE.setUsername("SYSTEM");
        DATA_SOURCE.setPassword("12345678");

        // 设置最大连接数
        DATA_SOURCE.setMaxTotal(25);
        // 设置初始连接数
        DATA_SOURCE.setInitialSize(5);
        //最小空闲连接
        DATA_SOURCE.setMinIdle(5);
        //最大空闲连接
        DATA_SOURCE.setMaxIdle(20);
        //超时等待时间毫秒
        DATA_SOURCE.setMaxWaitMillis(6000);
        // 会发现当前连接失效，再创建一个连接供当前查询使用
        DATA_SOURCE.setTestOnBorrow(true);
        // 设置缓存PrepredStatement
        DATA_SOURCE.setPoolPreparedStatements(true);
        // 将泄露的连接（写法糟糕，忘记关闭的连接）进行回收
        DATA_SOURCE.setRemoveAbandonedOnBorrow(true);
        // 泄露时长秒（如果连接泄露时长达到设置时间，那么会被回收）
        DATA_SOURCE.setRemoveAbandonedTimeout(300);
        // 设置测试SQL，默认测试SQL：select 1
        DATA_SOURCE.setValidationQuery("select 1 from dual");
    }


    public static Connection getConnection(){
        try {
            return DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
