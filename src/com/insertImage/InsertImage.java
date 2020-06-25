package com.insertImage;

import com.dbutils.DBUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertImage {
    @Test
    public void insertImage() throws Exception{
        Connection conn = DBUtils.getConn();
        FileInputStream in = new FileInputStream("G:\\RJGC\\web\\images\\python.jpg");
        String sql = "update  book set image = ? where bookId = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setBlob(1,in);
        ps.setInt(2,10);
        ps.executeUpdate();
    }

}
