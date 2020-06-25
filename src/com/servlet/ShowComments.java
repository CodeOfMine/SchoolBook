package com.servlet;

import com.bean.CommentsInfo;
import com.service.CommentService;
import com.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowComments",urlPatterns = "/showComments")
public class ShowComments extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        CommentService commentService = new CommentServiceImpl();
        List<CommentsInfo> allComments = commentService.getAllComments();
        HttpSession session = request.getSession();
        session.setAttribute("allComments",allComments);
        response.sendRedirect(request.getContextPath()+"/comments.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
