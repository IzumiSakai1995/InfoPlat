package infoplat.demo.service;

public interface Service {
    //登录
    public void login(String userphone,String password);
    //增加
    public void insert(String userphone,String password);
    //修改
    public void update(String userphone,String password);
    //删除
    public void delete(String userphone,String password);
}
