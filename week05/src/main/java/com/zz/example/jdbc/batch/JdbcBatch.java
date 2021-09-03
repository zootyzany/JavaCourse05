package com.zz.example.jdbc.batch;

import com.zz.example.jdbc.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sp0038
 * @date 2021/9/3
 */
public class JdbcBatch {
    public static final String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8&allowMultiQueries=true&serverTimezone=GMT%2B8";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User u1 = new User();
        u1.setUsername("q");
        u1.setAge(18);
        u1.setMobile("1231231");
        userList.add(u1);
        userList.add(u1);
        userList.add(u1);

        JdbcBatch jdbcBatch = new JdbcBatch();
        jdbcBatch.addList(userList);
    }

    public void addList(List<User> userList) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO t_user " +
                    "(username, age, mobile, create_time, update_time) " +
                    "values(?, ?, ?, CURRENT_DATE(), CURRENT_DATE())";
            pstm = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            for (User user : userList) {
                pstm.setString(1, user.getUsername());
                pstm.setInt(2, user.getAge());
                pstm.setString(3, user.getMobile());
                pstm.addBatch();
            }
            pstm.executeBatch();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
