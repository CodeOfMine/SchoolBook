package com.servlet;

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

@WebServlet(name = "DelCommentServlet",urlPatterns = "/delCommentServlet")
public class DelCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        Integer commentId = Integer.parseInt(id);
        CommentService commentService = new CommentServiceImpl();
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if(username.equals("管理员")) {
            commentService.deleteComment(commentId);
        }
        response.sendRedirect(request.getContextPath()+"/showComments");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
