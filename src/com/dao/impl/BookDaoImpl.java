package com.dao.impl;

import com.bean.Book;
import com.dao.BookDao;
import com.dbutils.DBUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookDaoImpl implements BookDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.getDataSource());

    @Override
    public List<Book> getAllBook() {
        try {
            String sql = "select * from book";
            List<Book> books = (List) jdbcTemplate.queryForList(sql);
            return books;
        }catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Book findBookById(int bookId) {
        try {
            String sql = "select * from book where bookId = ?";
            Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), bookId);
            return book;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
