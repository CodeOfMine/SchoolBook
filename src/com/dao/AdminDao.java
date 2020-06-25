package com.dao;

import com.bean.Admin;

public interface AdminDao {
    //管理员登录方法
    public Admin adminLogin(String name, String password);
}
