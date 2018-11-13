package com.lee.dbslaveaop.service.impl;

import com.lee.dbslaveaop.annoation.DB;
import com.lee.dbslaveaop.config.DataSourceHolder;
import com.lee.dbslaveaop.mapper.UserMapper;
import com.lee.dbslaveaop.model.User;
import com.lee.dbslaveaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @DB(DataSourceHolder.MATSERDB)
    public List<User> findMasterAllUser() {
        return userMapper.findAllUser();
    }
    @DB(DataSourceHolder.SLAVEDB)
    public List<User> findSlaveAllUser(){
        return userMapper.findAllUser();
    }
}
