package com.service;

import com.bean.Book;
import com.bean.BorrowInfo;
import com.bean.User;

import java.util.List;

public interface BorrowInfoService {
    //借书方法
    public void borrowBook(Book book, User user,String borrowTime);
    //查询方法
    public BorrowInfo getBorrowInfo(int userId,int bookId);
    //归还书籍方法
    public void backBook(int userId,int bookId,String backTime);
    //获取图书
    public List<BorrowInfo> getBookInfo(int userId);
}
