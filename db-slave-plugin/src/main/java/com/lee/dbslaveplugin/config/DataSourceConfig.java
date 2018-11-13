package com.lee.dbslaveplugin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.lee.dbslaveplugin.plugin.SQLPlugin;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DataSourceConfig {
    @Bean
    @Scope()
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource(){
        return new DruidDataSource();
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource(){
        return new DruidDataSource();
    }
    @Bean("dataSource")
    @Primary
    public DataSource routingDataSource(){
        RoutingDataSource dataSource = new RoutingDataSource();
        dataSource.setDefaultTargetDataSource(masterDataSource());
        HashMap<Object, Object> map = new HashMap<>();
        map.put("masterdb",masterDataSource());
        map.put("slavedb",slaveDataSource());
        dataSource.setTargetDataSources(map);
        return dataSource;
    }
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(){
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(routingDataSource());
        factory.setPlugins(new Interceptor[]{new SQLPlugin()});
        return factory;
    }
    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(routingDataSource());
        return transactionManager;
    }
}
