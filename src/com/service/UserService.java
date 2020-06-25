package com.service;

import com.bean.User;

public interface UserService {
    public void RegisterUser(User user);
    //根据用户名查id方法 判断该用户是否已经注册
    public Integer getUserIdByName(String username);
    //登录方法
    public User loginUser(String username,String password);

}
