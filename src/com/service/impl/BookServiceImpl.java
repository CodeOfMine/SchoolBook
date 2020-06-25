package com.service.impl;

import com.bean.Book;
import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.service.BookService;

import java.sql.Blob;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao =  new BookDaoImpl();

    @Override
    public List<Book> getAllBook() {
        return bookDao.getAllBook();
    }

    @Override
    public Book findBookById(int bookId) {
        return bookDao.findBookById(bookId);
    }


}
