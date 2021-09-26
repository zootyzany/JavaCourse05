package com.example.zz.week01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhouzeng
 */
@SpringBootApplication
@MapperScan(value = "com.example.zz.week01.mapper")
public class ShardingApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingApplication.class, args);
    }
}
