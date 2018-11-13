package com.lee.dbslaveaop.aop;

import com.lee.dbslaveaop.annoation.DB;
import com.lee.dbslaveaop.config.DataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
@Aspect
public class DbSwitch {
    @Pointcut("execution(* *.service.impl.*(..))")
    public void dbSwitch(){

    }
    @Before("@annotation(db)")
    public void doBefore(JoinPoint joinPoint, DB db){
        String value = db.value();
        if(null==value){
            value=DataSourceHolder.MATSERDB;
        }
        DataSourceHolder.setDbType(value);
    }
}
