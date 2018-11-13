package com.lee.dbslaveaop.service;

import com.lee.dbslaveaop.model.User;

import java.util.List;

public interface UserService {
    public List<User> findMasterAllUser();
    public List<User> findSlaveAllUser();
}
