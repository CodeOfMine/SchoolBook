package com.service;

import com.bean.Book;
import com.bean.CommentsInfo;
import com.bean.User;

import java.util.List;

public interface CommentService {
    //查看评论
    public List<CommentsInfo> getAllComments();
    //发表评论
    public void publishComment(User user, Book book, String time,String content);
    //删除评论
    public void deleteComment(int commentId);
}
