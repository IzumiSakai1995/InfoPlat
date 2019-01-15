package infoplat.demo.serviceImpl;

import infoplat.demo.daoImpl.Daoimpl;
import infoplat.demo.entity.User;
import infoplat.demo.service.Service;

public class ServiceImpl implements Service {

    Daoimpl dao = new Daoimpl();
    //登录
    @Override
    public void login(String userphone, String password) {

        dao.get(User.class,userphone,password);
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
