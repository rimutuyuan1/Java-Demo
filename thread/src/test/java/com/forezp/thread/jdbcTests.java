package com.forezp.thread;

import com.forezp.thread.jdbc.JdbcTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class jdbcTests {

    @Autowired
    private JdbcTest stringTest;

    @Test
    public void jdbcTest() {
        stringTest.jdbcTest("王鑫涛", "25");
    }
}
