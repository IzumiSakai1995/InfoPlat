package infoplat.demo.controller;

import infoplat.demo.serviceImpl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet.do")
public class loginServlet extends HttpServlet {
    ServiceImpl server = new ServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userphone = request.getParameter("userphone");
        String password = request.getParameter("password");
        server.login(userphone,password);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
