package com.zz.example.bean.m3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author sp0038
 * @date 2021/9/3
 */
@Data
@AllArgsConstructor
public class Bean {
    private String name;

    public void test() {
        System.out.println(name);
    }
}
