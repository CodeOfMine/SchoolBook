package com.service;

import com.bean.Admin;

public interface AdminService {
    //管理员登录方法
    public Admin adminLogin(String name, String password);
}
