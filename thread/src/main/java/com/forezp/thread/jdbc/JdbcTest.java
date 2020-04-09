package com.forezp.thread.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void jdbcTest(String name, String age) {
        jdbcTemplate.update("INSERT INTO T_USER VALUES (NULL,?,?)", name, age);
    }
}
