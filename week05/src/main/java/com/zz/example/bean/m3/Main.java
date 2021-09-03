package com.zz.example.bean.m3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sp0038
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Bean bean = context.getBean(Bean.class);
        System.out.println(bean);
    }
}
