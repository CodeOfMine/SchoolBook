package com.dao.impl;

import com.bean.Book;
import com.bean.BorrowInfo;
import com.bean.User;
import com.dao.BorrowInfoDao;
import com.dbutils.DBUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class BorrowInfoImpl implements BorrowInfoDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.getDataSource());
    @Override
    public void borrowBook(Book book, User user,String borrowTime) {
        try {
            String sql = "insert into borrowinfo (userId,bookId,username,bookName,borrowTime,isbn,author) values(?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql,user.getUserId(),book.getBookId(),user.getName(),book.getBookName(),borrowTime,book.getIsbn(),book.getAuthor());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public BorrowInfo getBorrowInfo(int userId, int bookId) {
        try {
            String sql = "select * from borrowinfo where userId = ? and bookId = ?";
            BorrowInfo borrowInfo = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(BorrowInfo.class),userId,bookId);
            return  borrowInfo;
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public void backBook(int userId, int bookId,String backTime) {
        try {
            String sql = "update borrowInfo set backTime = ? where userId = ? and bookId = ?";
            jdbcTemplate.update(sql,backTime,userId,bookId);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BorrowInfo> getBookInfo(int userId) {
        try {
            String sql = "select * from borrowinfo where userId = ?";
            List<BorrowInfo> borrowInfos = (List)jdbcTemplate.queryForList(sql, userId);
            return borrowInfos;
        }catch (Exception e ) {
            e.printStackTrace();
            return null;
        }
    }


}
