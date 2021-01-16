package com.lgh;

import com.lgh.entity.UserTable;
import com.lgh.mapper.UserTableMapper;
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
    private UserTableMapper userTableMapper;

    @Test
    public void testSql() {
        List<UserTable> list = new ArrayList<>();
        UserTable table1 = new UserTable();
        table1.setId("1");
        table1.setName("张三1");
        UserTable table2 = new UserTable();
        table2.setId("2");
        table2.setName("张三2");
        UserTable table3 = new UserTable();
        table3.setId("3");
        table3.setName("张三3");
        list.add(table1);
        list.add(table2);
        list.add(table3);
        userTableMapper.updateByList(list);
    }
}
