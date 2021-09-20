package com.zz.example.work02.aop;

import com.zz.example.work02.datasource.DbContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zhouzeng
 */
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("@annotation(com.zz.example.work02.annotation.Slave) ")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.zz.example.work02.annotation.Master) ")
    public void writePointcut() {

    }

    @Around("readPointcut()")
    public void read(ProceedingJoinPoint point) throws Throwable {
        DbContextHolder.slave();
        point.proceed();
//        DbContextHolder.remove();
    }

    @Around("writePointcut()")
    public void write(ProceedingJoinPoint point) throws Throwable {
        DbContextHolder.master();
        point.proceed();
//        DbContextHolder.remove();
    }
}