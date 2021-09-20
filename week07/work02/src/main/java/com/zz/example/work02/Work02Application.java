package com.zz.example.work02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhouzeng
 */
@SpringBootApplication
@MapperScan("com.zz.example.work02.biz.dao")
public class Work02Application {

    public static void main(String[] args) {
        SpringApplication.run(Work02Application.class, args);
    }
}
