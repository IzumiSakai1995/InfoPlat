package infoplat.demo.dao;

import infoplat.demo.utils.JDBCUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

public interface Dao {
    /**
    * 执行增，删，改操作
    * */
    public void update(String sql, Object... args);
    /**
    * 获取对象
    * */
    public <T> T get(Class<T> clazz,String sql,Object ... args);

    /**
     * 得到所以用户对象
     */
    public List<Map<String,Object>> query(String sql);
}
