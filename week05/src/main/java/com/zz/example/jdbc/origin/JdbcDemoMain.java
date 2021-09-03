package com.zz.example.jdbc.origin;

import com.zz.example.jdbc.User;

/**
 * @author sp0038
 * @date 2021/9/3
 */
public class JdbcDemoMain {
    public static void main(String[] args) {
        JdbcDemo jdbc = new JdbcDemo();
        User user = User.builder().username("test").age(18).mobile("18811111111").id(1).build();
        jdbc.addUser(user);

        User u = jdbc.get(6);
        System.out.println(u);

        u.setMobile("18112312312");
        jdbc.updateUser(u);

        jdbc.delUser(20);
    }
}
