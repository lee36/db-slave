package com.lee.dbslaveplugin;

import com.lee.dbslaveplugin.mapper.UserMapper;
import com.lee.dbslaveplugin.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbSlavePluginApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void contextLoads() {
     userMapper.findAllUser();
    }
    @Test
    public void contextLoads1() {
        User user = new User();
        user.setAge(80);
        user.setUsername("haahahah");
        userMapper.addUser(user);
    }

}
