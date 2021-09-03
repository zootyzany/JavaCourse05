package com.zz.example.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sp0038
 * @date 2021/9/3
 */
public class Main1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();
//        User user = User.builder().username("test").age(18).mobile("18811111111").id(1).build();
//        dao.addUser(user);
//
//        User u = dao.get(6);
//        System.out.println(u);
//
//        u.setMobile("18112312312");
//        dao.updateUser(u);
//
//        dao.delUser(1);


        List<User> userList = new ArrayList<>();
        User u1 = new User();
        u1.setUsername("q");
        u1.setAge(18);
        u1.setMobile("1231231");
        userList.add(u1);
        userList.add(u1);
        userList.add(u1);

        dao.addList(userList);
    }
}
