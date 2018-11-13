package com.lee.dbslaveaop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableAspectJAutoProxy
@MapperScan("com.lee.dbslaveaop.mapper")
public class DbSlaveAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbSlaveAopApplication.class, args);
    }
}
