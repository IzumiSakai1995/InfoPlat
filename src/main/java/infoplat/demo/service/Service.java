package infoplat.demo.service;

import java.util.List;
import java.util.Map;

public interface Service {
    //登录
    public Map<String,Object> login(String userphone, String password);
    //查询所以用户信息
    public List<Map<String,Object>> query();
    //根据手机号查询该用户所以的信息
    public List<Map<String, Object> >select(String userphone);
    //增加用户
    public void insert(String userphone, String password,String username,String iRoleId,int id);
    //修改用户id管理员操作的id
    public void update(String username,String userphone,int id,String iRoleId,String sTel);
    //删除用户
    public void delete(String sTel);
}
