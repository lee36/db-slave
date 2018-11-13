package com.lee.dbslavepackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DbSlavePackageApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbSlavePackageApplication.class, args);
    }
}
