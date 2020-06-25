package com.servlet;

import com.bean.Admin;
import com.bean.User;
import com.service.AdminService;
import com.service.UserService;
import com.service.impl.AdminServiceImpl;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String status = request.getParameter("status");
        UserService userService = new UserServiceImpl();
        AdminService adminService = new AdminServiceImpl();
        HttpSession session = request.getSession();
        if("管理员".equals(status)) {
            Admin admin = adminService.adminLogin(username, password);
            if(admin==null) {
                session.setAttribute("loginMsg","您不是管理员，登陆失败！");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                session.setAttribute("username","管理员");
                response.sendRedirect(request.getContextPath()+"/bookListServlet");
            }
        }else {
            User user = userService.loginUser(username, password);
            if(user==null) {
                //登录失败
                session.setAttribute("loginMsg","用户名或密码输入错误！");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                //登录成功 跳转到主界面
                session.setAttribute("username",username);
                session.setAttribute("user",user);
                response.sendRedirect(request.getContextPath()+"/bookListServlet");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
