package com.lgh;

import com.lgh.mapper.UserMapper;
import com.lgh.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RunApplicationTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSql() {
        List<User> list = new ArrayList<>();
        User table1 = new User();
        table1.setId(1);
        table1.setUserName("张三1");
        User table2 = new User();
        table2.setId(2);
        table2.setUserName("张三2");
        User table3 = new User();
        table3.setId(3);
        table3.setUserName("张三3");
        list.add(table1);
        list.add(table2);
        list.add(table3);
        userMapper.updateByList(list);
    }
}
