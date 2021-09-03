package com.zz.example.starter;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


/**
 * @author zhouzeng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable/*, BeanNameAware, ApplicationContextAware*/ {


    private int id;
    private String name;

    public void init() {
        System.out.println("hello...........");
    }

//    public static Student create(){
//        return new Student(102,"KK102",null, null);
//    }

//    public void print() {
//        System.out.println(this.beanName);
//        System.out.println("   context.getBeanDefinitionNames() ===>> "
//                + String.join(",", applicationContext.getBeanDefinitionNames()));
//
//    }


}
