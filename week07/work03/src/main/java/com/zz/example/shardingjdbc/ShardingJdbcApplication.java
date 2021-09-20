package com.zz.example.shardingjdbc;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouzeng
 */
@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.zz.example.shardingjdbc.biz.dao")
public class ShardingJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcApplication.class, args);
    }

}
