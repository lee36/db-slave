package com.lee.dbslavepackage;


import com.lee.dbslavepackage.mapper.slave.UserMapper;
import com.lee.dbslavepackage.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbSlavePackageApplicationTests {
//    @Autowired
//    @Qualifier(value = "masterUserMapper")
//    private UserMapper userMapper;

    @Autowired
    @Qualifier(value = "slaveUserMapper")
    private UserMapper userMapper;
    @Test
    public void contextLoads() {
        List<User> allUser = userMapper.findAllUser();
        System.out.println(allUser.size());
    }

}
