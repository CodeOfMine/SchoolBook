package com.dao.impl;

import com.bean.Admin;
import com.dao.AdminDao;
import com.dbutils.DBUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.getDataSource());
    @Override
    public Admin adminLogin(String name, String password) {
        try {
            String sql = "select * from admin where adminName = ? and password = ?";
            Admin admin = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), name, password);
            return admin;
        }catch (Exception ex) {
            return null;
        }
    }
}
