package com.lee.dbslaveplugin.mapper;



import com.lee.dbslaveplugin.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<User> findAllUser();
    @Insert("insert into user(username,age) values(#{username},#{age})")
    @Options(keyProperty = "id",keyColumn = "id",useGeneratedKeys = true)
    public int addUser(User user);
}
