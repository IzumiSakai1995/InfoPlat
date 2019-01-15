package infoplat.demo.serviceImpl;

import infoplat.demo.daoImpl.Daoimpl;
import infoplat.demo.service.Service;

public class ServiceImpl implements Service {

    Daoimpl dao = new Daoimpl();
    //登录
    @Override
    public void login(String userphone, String password) {

    }

    @Override
    public void insert(String userphone, String password) {
        String sql = "insert into tadmin(sName,sTel,sPwd,dtInsert,iInsertAdmin,dtUpdate,iUpdateAdmin,iRoleId) VALUES(?,?,?,SYSDATE(),?,SYSDATE(),?,?);";
        dao.update(sql,userphone,password);
    }

    @Override
    public void update(String userphone, String password) {

    }

    @Override
    public void delete(String userphone, String password) {

    }
    //增加

}
