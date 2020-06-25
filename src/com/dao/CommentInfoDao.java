package com.dao;

import com.bean.Book;
import com.bean.CommentsInfo;
import com.bean.User;

import java.util.List;

public interface CommentInfoDao {
    //查看评论
    public List<CommentsInfo> getAllComments();
    //发表评论
    public void publishComment(User user, Book book,String time,String content);
    //删除评论
    public void deleteComment(int commentId);
}
