package com.example.book.test;

import com.example.book.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtilsTest {
    @Test
    public void TestJdbcUtils(){
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }

}
