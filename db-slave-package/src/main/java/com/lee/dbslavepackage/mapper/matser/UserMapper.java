package com.lee.dbslavepackage.mapper.matser;

import com.lee.dbslavepackage.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("masterUserMapper")
public interface UserMapper {
    @Insert("insert into user(id,username,age) values(#{id},#{username},#{age})")
    public int addUser(User user);
}
