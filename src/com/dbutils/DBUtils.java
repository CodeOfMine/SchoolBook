package com.dbutils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 数据库连接的公共类
 */
public class DBUtils {
    private static DataSource dataSource;
    static {
        try {
            InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConn() throws Exception {
        return dataSource.getConnection();
    }
}
