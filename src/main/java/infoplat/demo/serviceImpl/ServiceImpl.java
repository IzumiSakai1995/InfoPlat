package infoplat.demo.serviceImpl;

import infoplat.demo.daoImpl.Daoimpl;
import infoplat.demo.entity.User;
import infoplat.demo.service.Service;
import org.junit.Test;

public class ServiceImpl implements Service {

    Daoimpl dao = new Daoimpl();
    //登录
    @Override
    public void login(String userphone, String password) {
        String sql = "select sName from tadmin whrer sTel = ? and sPwd = ?";
       User user = dao.get(User.class,userphone,password);
       if (user==null){
           System.out.println("查无此人");
       }else {
           // TODO: 2019/1/15 重定向或者转发
       }
    }

    @Test
    public void test(){
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
