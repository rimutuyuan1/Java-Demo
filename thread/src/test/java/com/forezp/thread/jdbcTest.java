package com.forezp.thread;

import com.forezp.thread.jdbc.StringTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest
@RunWith(SpringRunner.class)
public class jdbcTest {

    @Autowired
    private StringTest stringTest;

    @Test
    public void jdbcTest() {
        stringTest.jdbcTest("王鑫涛", "20");
    }
}
