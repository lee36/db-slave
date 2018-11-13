package com.lee.dbslaveaop;

import com.lee.dbslaveaop.model.User;
import com.lee.dbslaveaop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbSlaveAopApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    public void contextLoads() {
        List<User> masterAllUser = userService.findMasterAllUser();
        System.out.println(masterAllUser.size()+"======");
        List<User> slaveAllUser = userService.findSlaveAllUser();
        System.out.println(slaveAllUser.size()+"=======");
    }

}
