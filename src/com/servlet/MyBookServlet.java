package com.servlet;

import com.bean.Book;
import com.bean.BorrowInfo;
import com.bean.User;
import com.service.BookService;
import com.service.BorrowInfoService;
import com.service.impl.BookServiceImpl;
import com.service.impl.BorrowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MyBookServlet",urlPatterns = "/myBookServlet")
public class MyBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        BorrowInfoService borrowInfoService = new BorrowServiceImpl();
        List<BorrowInfo> borrowInfos = borrowInfoService.getBookInfo(user.getUserId());
        session.setAttribute("borrowInfo",borrowInfos);
        response.sendRedirect(request.getContextPath()+"/MyBook.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
