package infoplat.demo.service;

import java.util.List;
import java.util.Map;

public interface Service {
    //登录
    public Map<String,Object> login(String userphone, String password);
    //
    public List<Map<String,Object>> query();
    //增加
    public void insert(String username,String password);
    //修改
    public void update(String username,String userphone);
    //删除
    public void delete(String username);
}
