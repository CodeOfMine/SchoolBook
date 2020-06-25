package com.servlet;

import com.bean.Book;
import com.service.BookService;
import com.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

@WebServlet(name = "FindBookServlet",urlPatterns = "/findBookServlet")
public class FindBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String book_Id = request.getParameter("id");
        Integer bookId = Integer.parseInt(book_Id);
        BookService bookService = new BookServiceImpl();
        Book book = bookService.findBookById(bookId);
        HttpSession session = request.getSession();
        session.setAttribute("bookInfo",book);
        response.sendRedirect(request.getContextPath()+"/borrow.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
