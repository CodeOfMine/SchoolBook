package com.servlet;

import com.bean.Book;
import com.bean.User;
import com.service.CommentService;
import com.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "PublishComment",urlPatterns = "/publishComment")
public class PublishComment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String content = request.getParameter("content");
        User user = (User)session.getAttribute("user");
        Book book = (Book)session.getAttribute("bookInfo");
        if(username == null) {
            response.sendRedirect(request.getContextPath()+"/loginServlet");
        }else {
            CommentService commentService = new CommentServiceImpl();
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分:ss秒");
            String time = dateFormat.format(date);
            commentService.publishComment(user,book,content,time);
            response.sendRedirect(request.getContextPath()+"/showComments");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
