package infoplat.demo.controller;

import infoplat.demo.serviceImpl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "administratorsServlet.do")
public class administratorsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String but = request.getParameter("button");
        String username = request.getParameter("username");
        String userphone = request.getParameter("userphone");
        String password = request.getParameter("password");
        ServiceImpl service = new ServiceImpl();
        if ("1".equals(but)) {
//展示用户列表

        } else if ("2".equals(but)) {
//新增用户信息

    service.insert(username,userphone);
        } else if ("3".equals(but)) {
//修改用户信息
    service.update(userphone,password);
        } else if ("4".equals(but)) {
//删除用户信息
    service.delete(username);
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
