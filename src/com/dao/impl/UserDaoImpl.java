package com.dao.impl;

import com.bean.User;
import com.dao.UserDao;
import com.dbutils.DBUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.getDataSource());

    @Override
    public void RegisterUser(User user) {
        try {
            String sql = "insert into user (username,name,gender,password) values(?,?,?,?)";
            jdbcTemplate.update(sql,user.getUsername(),user.getName(),user.getGender(),user.getPassword());
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Integer getUserIdByName(String username) {
        try {
            String sql = "select userId from user where username = ?";
            Integer userId = jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);
            return userId;
        }catch (Exception ex) {
            return null;
        }
    }

    @Override
    public User loginUser(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        }catch (Exception ex) {
            return null;
        }
    }
}
