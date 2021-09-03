package com.zz.example.bean.m2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sp0038
 * @date 2021/9/3
 */
@Configuration
public class BeanConfig {
    @Bean
    public com.zz.example.bean.m2.Bean bean() {
        return new com.zz.example.bean.m2.Bean();
    }
}
