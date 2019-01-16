package infoplat.demo.controller;

import infoplat.demo.serviceImpl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "administratorsServlet.do")
public class administratorsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceImpl server = new ServiceImpl();
        String but = request.getParameter("button");
        String username = request.getParameter("username");
        String userphone = request.getParameter("userphone");
        String password = request.getParameter("password");
        String iRoleId = request.getParameter("iRoleId");
        //获取要修改项的iTel
        String sTel = request.getParameter("sTel");
        //当前管理员登录的id
        int id = (Integer) request.getAttribute("id");
        //展示所以用户的基本信息*
        ServiceImpl service = new ServiceImpl();
        List<Map<String,Object>> list = new ArrayList<>();
        list = server.query();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/主界面（查看所以用户的列表）").forward(request,response);
        if ("1".equals(but)) {
//根据手机号查询用户列表*
            List<Map<String,Object>> list1 = new ArrayList<>();
            list1 = server.select(userphone);
            request.setAttribute("list",list1);
            request.getRequestDispatcher("/新的列表界面（查看所以用户的列表）").forward(request,response);
        } else if ("2".equals(but)) {
//新增用户信息*
    service.insert(username,userphone,password,iRoleId,id);
        } else if ("3".equals(but)) {
//修改用户信息
    service.update(username,userphone,id,iRoleId,sTel);
        } else if ("4".equals(but)) {
//删除用户信息
    service.delete(sTel);
        } else if ("5".equals(but)) {
//展示信息列表

        } else if ("6".equals(but)) {
//展示新增信息

        } else if ("7".equals(but)) {
//展示修改信息

        } else if ("8".equals(but)) {
//展示删除信息

        } else if ("9".equals(but)) {
//查看留言

        } else if ("10".equals(but)) {
//删除留言

        } else if ("11".equals(but)) {
//设置留言
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
