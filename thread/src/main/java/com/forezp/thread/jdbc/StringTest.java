package com.forezp.thread.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StringTest {

    private JdbcTemplate jdbcTemplate;

    public void jdbcTest(String name, String age) {
        jdbcTemplate.update("INSERT INTO USER VALUES (null,?,?)", name, age);
    }
}
