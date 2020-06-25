package com.service.impl;

import com.bean.Book;
import com.bean.CommentsInfo;
import com.bean.User;
import com.dao.CommentInfoDao;
import com.dao.impl.CommentDaoImpl;
import com.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentInfoDao commentInfoDao = new CommentDaoImpl();
    @Override
    public List<CommentsInfo> getAllComments() {
        return commentInfoDao.getAllComments();
    }

    @Override
    public void publishComment(User user, Book book, String content,String time) {
        commentInfoDao.publishComment(user, book, content,time);
    }

    @Override
    public void deleteComment(int commentId) {
        commentInfoDao.deleteComment(commentId);
    }
}
