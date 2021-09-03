package com.zz.example.starter;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sp0038
 * @date 2021/9/3
 */
@Configuration
@ConditionalOnClass({Student.class, Klass.class, Student.class})
@AutoConfigureAfter({MongoAutoConfiguration.class})
public class SchoolAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Student student() {
        return new Student();
    }

    @Bean
    @ConditionalOnMissingBean
    public Klass klass() {
        return new Klass();
    }

    @Bean
    @ConditionalOnMissingBean
    public ISchool school() {
        return new School();
    }
}
