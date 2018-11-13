package com.lee.dbslavepackage.mapper.slave;

import com.lee.dbslavepackage.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("slaveUserMapper")
public interface UserMapper {
    @Select("select * from user")
    public List<User> findAllUser();
}
