package com.dao.impl;

import com.bean.Book;
import com.bean.CommentsInfo;
import com.bean.User;
import com.dao.CommentInfoDao;
import com.dbutils.DBUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class CommentDaoImpl implements CommentInfoDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.getDataSource());
    @Override
    public List<CommentsInfo> getAllComments() {
        try {
            String sql = "select * from commentinfo";
            List<CommentsInfo> commentsInfo = (List)jdbcTemplate.queryForList(sql);
            return commentsInfo;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void publishComment(User user, Book book,String content,String time) {
        try {
            String sql = "insert into commentinfo (userId,bookId,bookName,username,content,time) values(?,?,?,?,?,?)";
            jdbcTemplate.update(sql,user.getUserId(),book.getBookId(),book.getBookName(),user.getUsername(),content,time);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteComment(int commentId) {
        try {
            String sql = "delete from commentinfo where commentId = ?";
            jdbcTemplate.update(sql,commentId);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
