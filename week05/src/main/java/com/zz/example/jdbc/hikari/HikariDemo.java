package com.zz.example.jdbc.hikari;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author sp0038
 * @date 2021/9/3
 */
public class HikariDemo {
    public static void main(String[] args) {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true");
        dataSource.setPassword("123456");
        dataSource.setUsername("root");
        dataSource.setMinimumIdle(10);
        dataSource.setMaximumPoolSize(100);
        dataSource.setMaxLifetime(60000);

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        String sql = "INSERT INTO t_user(username, age, mobile, create_time, update_time)"
                + "values(?,?,?,CURRENT_DATE(),CURRENT_DATE())";
        jdbcTemplate.update(sql, "Jack", 18, "110");
    }
}
