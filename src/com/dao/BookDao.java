package com.dao;

import com.bean.Book;

import java.sql.Blob;
import java.util.List;

public interface BookDao {
    //查询所有图书的方法
    public List<Book> getAllBook();
    //查询图书的方法
    public Book findBookById(int bookId);

}
