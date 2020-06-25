package com.service.impl;

import com.bean.Book;
import com.bean.BorrowInfo;
import com.bean.User;
import com.dao.BorrowInfoDao;
import com.dao.impl.BorrowInfoImpl;
import com.service.BorrowInfoService;

import java.util.List;

public class BorrowServiceImpl implements BorrowInfoService {
    private BorrowInfoDao borrowInfoDao = new BorrowInfoImpl();
    @Override
    public void borrowBook(Book book, User user,String borrowTime) {
        borrowInfoDao.borrowBook(book,user,borrowTime);
    }

    @Override
    public BorrowInfo getBorrowInfo(int userId, int bookId) {
        return borrowInfoDao.getBorrowInfo(userId,bookId);
    }

    @Override
    public void backBook(int userId, int bookId,String backTime) {
        borrowInfoDao.backBook(userId, bookId,backTime);
    }

    @Override
    public List<BorrowInfo> getBookInfo(int userId) {
        return borrowInfoDao.getBookInfo(userId);
    }
}
