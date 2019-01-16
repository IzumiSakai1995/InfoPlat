package infoplat.demo.controller;

import infoplat.demo.serviceImpl.ServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/login")
public class loginServlet extends HttpServlet {
    ServiceImpl server = new ServiceImpl();
    @Override
    @RequestMapping("/")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userphone = request.getParameter("userPhone");
        String password = request.getParameter("password");
        System.out.println(userphone+password);
        Map<String,Object> map = server.login(userphone,password);
        int a = (int) map.get("status");
        if (a>0){
            request.setAttribute("msg",map.get("text"));
            request.getRequestDispatcher("/login.html").forward(request,response);
            //跳转到主界面
        }else{
            request.setAttribute("msg",map.get("text"));
            request.getRequestDispatcher("/login.html");
            //跳转到登录界面
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
    }
}
