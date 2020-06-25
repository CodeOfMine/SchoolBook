package com.service.impl;

import com.bean.Admin;
import com.dao.AdminDao;
import com.dao.impl.AdminDaoImpl;
import com.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin adminLogin(String name, String password) {
        return adminDao.adminLogin(name,password);
    }
}
