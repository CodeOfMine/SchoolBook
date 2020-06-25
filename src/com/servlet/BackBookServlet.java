package com.servlet;

import com.bean.Book;
import com.bean.BorrowInfo;
import com.bean.User;
import com.service.BorrowInfoService;
import com.service.impl.BorrowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "BackBookServlet",urlPatterns = "/backBookServlet")
public class BackBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if(username == null) {
            //没有登录
            session.setAttribute("backInfoMsg","对不起，请先登录！");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else {
            BorrowInfoService borrowInfoService = new BorrowServiceImpl();
            User user = (User) session.getAttribute("user");
            Book book = (Book) session.getAttribute("bookInfo");
            BorrowInfo borrowInfo = borrowInfoService.getBorrowInfo(user.getUserId(), book.getBookId());
            if(borrowInfo!=null) {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分");
                String time = simpleDateFormat.format(date);
                borrowInfoService.backBook(user.getUserId(),book.getBookId(),time);
                response.sendRedirect(request.getContextPath()+"/myBookServlet");
            }else {
                session.setAttribute("backInfoMsg","对不起，您没有借过这本书！");
                response.sendRedirect(request.getContextPath()+"/bookListServlet");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
