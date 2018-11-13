package com.lee.dbslaveplugin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.lee.dbslaveplugin.mapper")
public class DbSlavePluginApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbSlavePluginApplication.class, args);
    }
}
