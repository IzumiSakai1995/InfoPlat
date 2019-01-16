package infoplat.demo.serviceImpl;

import infoplat.demo.daoImpl.Daoimpl;
import infoplat.demo.entity.User;
import infoplat.demo.service.Service;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ServiceImpl implements Service {

    Daoimpl dao = new Daoimpl();
    //登录
    @Override
    public Map<String, Object> login(String userphone, String password) {
        String sql = "select sName from tadmin whrer sTel = ? and sPwd = ?";
       User user = dao.get(User.class,userphone,password);
       Map<String,Object> map = new LinkedHashMap<>();
       if (user==null){
           map.put("status",-1);
           map.put("text","密码或账号错误");
           return map;
       }else {
           map.put("status",1);
           map.put("text","登录成功");
           return map;
       }
    }

    //查询所以用户
    @Override
    public List<Map<String, Object> >query() {
        String sql ="select iAdminId,sName,dtInsert,dtUpdate,iRoleId\n" +
                " from tAdmin";
        User user = dao.get(User.class,"");
        return null;
    }


    @Test
    public void test(){
        // TODO: 2019/1/15 测试方法  项目结束后删除
        String sTel = "13086617754";
        String sPwd = "E10ADC3949BA59ABBE56E057F20F883E";
        String sql = "select sName from tadmin where sTel = ? and sPwd = ?";
        User user = dao.get(User.class,sql,sTel,sPwd);
        System.out.println(user);
    }


    @Override
    public void insert(String userphone, String password) {
        String sql = "insert into tadmin(sName,sTel,sPwd,dtInsert,iInsertAdmin,dtUpdate,iUpdateAdmin,iRoleId) VALUES(?,?,?,SYSDATE(),?,SYSDATE(),?,?);";
        dao.update(sql,userphone,password);
    }

    @Override
    public void update(String username, String userphone) {
        String sql = "update tadmin SET sName = ?,sTel = ? where iAdminId=1;";
        dao.update(sql,username,userphone);
    }

    @Override
    public void delete(String username) {
        String sql = "delete from tadmin where sName = ?";
        dao.update(sql,username);
    }

}
