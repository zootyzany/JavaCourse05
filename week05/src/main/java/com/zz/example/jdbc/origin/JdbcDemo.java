package com.zz.example.jdbc.origin;

import com.zz.example.jdbc.User;

import java.sql.*;

/**
 * @author sp0038
 * @date 2021/9/3
 */
public class JdbcDemo {
    public static final String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8&allowMultiQueries=true&serverTimezone=GMT%2B8";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public void addUser(User user) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO t_user(username, age, mobile, create_time, update_time)"
                    + "values(?,?,?,CURRENT_DATE(),CURRENT_DATE())";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, user.getUsername());
            pstm.setInt(2, user.getAge());
            pstm.setString(3, user.getMobile());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeResource(conn, pstm);
        }
    }

    public void updateUser(User user) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "UPDATE t_user" +
                    " set username=?,age=?, mobile=?, update_time=CURRENT_DATE()" +
                    " where id=?";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, user.getUsername());
            pstm.setInt(2, user.getAge());
            pstm.setString(3, user.getMobile());
            pstm.setInt(4, user.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeResource(conn, pstm);
        }

    }

    public void delUser(Integer id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //sql, 每行加空格
            String sql = "DELETE from t_user where id=?";
            //预编译SQL，减少sql执行
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeResource(conn, pstm);
        }
    }

    public User get(Integer id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            User user = null;
            //sql, 每行加空格
            String sql = "SELECT * from  t_user where id=?";
            //预编译SQL，减少sql执行
            pstm = conn.prepareStatement(sql);
            //传参
            pstm.setInt(1, id);
            //执行
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setAge(rs.getInt("age"));
                user.setMobile(rs.getString("mobile"));
                user.setCreateTime(rs.getDate("create_time"));
                user.setUpdateTime(rs.getDate("update_time"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeResource(conn, pstm);
        }
    }

    public void closeResource(Connection conn,
                              PreparedStatement pstm) {
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
