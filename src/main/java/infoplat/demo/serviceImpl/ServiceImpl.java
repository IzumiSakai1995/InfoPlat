package infoplat.demo.serviceImpl;

import infoplat.demo.daoImpl.Daoimpl;
import infoplat.demo.entity.User;
import infoplat.demo.service.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ServiceImpl implements Service {

    Daoimpl dao = new Daoimpl();
    //登录
    @Override
    public Map<String, Object> login(String userphone, String password) {
        String sql = "select sName from tadmin where sTel = ? and sPwd = ?";
       User user = dao.get(User.class,sql,userphone,password);
        System.out.println(user);
       Map<String,Object> map = new LinkedHashMap<>();
       if (user==null){
           map.put("status",-1);
           map.put("text","密码或账号错误");
           return map;
       }else {
           map.put("status",1);
           map.put("id",user.getIAdminId());
           map.put("text","登录成功");
           return map;
       }
    }

    //查询所以用户
    @Override
    public List<Map<String, Object> >query() {
        String sql = "select sName,sTel,dtInsert ,iInsertAdmin,dtUpdate,iUpdateAdmin,iRoleId from tadmin ";
        List<Map<String,Object>> list = new ArrayList<>();
        list = dao.query(sql);
        return list;
    }

    //根据手机号查询该用户所以的信息
    @Override
    public List<Map<String, Object>> select(String userphone) {
        String sql = "select a.sName sAdminName,a.sTel,\n" +
                "\t\t\tf.iFunId,f.sFun,f.sName,f.iType,f.iParent\n" +
                " from tAdmin a,tRoleFun rf,tFun f\n" +
                "where a.iRoleId = rf.iRoleId\n" +
                "  and rf.iFunId = f.iFunId\n" +
                "  and a.sTel = ?";
        List<Map<String,Object>> list = new ArrayList<>();
        list = dao.select(sql,userphone);
        return list;
    }



    @Override
    public void insert(String userphone, String password,String username,String iRoleId,int id) {
        String sql = "insert into tAdmin(sName,sTel,sPwd,dtInsert,iInsertAdmin,dtUpdate,iUpdateAdmin,iRoleId) VALUES(?,?,?,SYSDATE(),?,SYSDATE(),?,?);";
        dao.update(sql,username,userphone,password,id,id,iRoleId);
    }

    @Override
    public void update(String username, String userphone,int id,String iRoleId ,String sTel) {
        String sql = "update tadmin SET sName = ?,sTel = ? ,dtUpdate = SYSDATE(),iUpdateAdmin=?,iRoleId= ? where sTel = ?;";
        dao.update(sql,username,userphone,id,iRoleId,sTel);
    }

    @Override
    public void delete(String sTel) {
        String sql = "delete from tadmin where sTel = ?";
        dao.update(sql,sTel);
    }

}
