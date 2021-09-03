package com.zz.example.bean.m2;

import org.springframework.stereotype.Component;

/**
 * @author sp0038
 * @date 2021/9/3
 */
@Component
public class Bean {
    private String name;

    public void test() {
        System.out.println(name);
    }
}
