package com.zz.example.jdbc;

import java.sql.*;
import java.util.List;


/**
 * @author zhouzeng
 */
public class UserDao {
    public static final String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8&allowMultiQueries=true&serverTimezone=GMT%2B8";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public void addUser(User user) throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn = null;
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //sql
        String sql = "INSERT INTO t_user(username, age, mobile, create_time, update_time)"
                + "values(?,?,?,CURRENT_DATE(),CURRENT_DATE())";
        //预编译
        //预编译SQL，减少sql执行
        PreparedStatement ps = conn.prepareStatement(sql);

        //传参
        ps.setString(1, user.getUsername());
        ps.setInt(2, user.getAge());
        ps.setString(3, user.getMobile());

        //执行
        ps.execute();
        ps.close();
        conn.close();

    }

    public void updateUser(User user) throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn = null;
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //sql, 每行加空格
        String sql = "UPDATE t_user" +
                " set username=?,age=?, mobile=?, update_time=CURRENT_DATE()" +
                " where id=?";
        //预编译
        //预编译SQL，减少sql执行
        PreparedStatement ps = conn.prepareStatement(sql);

        //传参
        ps.setString(1, user.getUsername());
        ps.setInt(2, user.getAge());
        ps.setString(3, user.getMobile());
        ps.setInt(4, user.getId());

        //执行
        ps.execute();
        ps.close();
        conn.close();
    }

    public void delUser(Integer id) throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn = null;
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //sql, 每行加空格
        String sql = "delete from t_user where id=?";
        //预编译SQL，减少sql执行
        PreparedStatement ps = conn.prepareStatement(sql);

        //传参
        ps.setInt(1, id);

        //执行
        ps.execute();
        ps.close();
        conn.close();
    }

    public User get(Integer id) throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn = null;
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        User user = null;
        //sql, 每行加空格
        String sql = "select * from  t_user where id=?";
        //预编译SQL，减少sql执行
        PreparedStatement ps = conn.prepareStatement(sql);
        //传参
        ps.setInt(1, id);
        //执行
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setAge(rs.getInt("age"));
            user.setMobile(rs.getString("mobile"));
            user.setCreateTime(rs.getDate("create_time"));
            user.setUpdateTime(rs.getDate("update_time"));
        }
        ps.close();
        conn.close();
        return user;
    }


    public void addList(List<User> userList) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rt = null;
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