package infoplat.demo.controller;

import infoplat.demo.serviceImpl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "loginServlet.do")
public class loginServlet extends HttpServlet {
    ServiceImpl server = new ServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userphone = request.getParameter("userphone");
        String password = request.getParameter("password");
        Map<String,Object> map = server.login(userphone,password);
        int a = (int) map.get("status");
        if (a>0){
            request.setAttribute("msg",map.get("text"));
            request.getRequestDispatcher("../主界面").forward(request,response);
            //跳转到主界面
        }else{
            request.setAttribute("msg",map.get("text"));
            request.getRequestDispatcher("../登录界面");
            //跳转到登录界面
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
