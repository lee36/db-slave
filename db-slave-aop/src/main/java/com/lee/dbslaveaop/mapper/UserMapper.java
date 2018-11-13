package com.lee.dbslaveaop.mapper;

import com.lee.dbslaveaop.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    public List<User> findAllUser();
}
