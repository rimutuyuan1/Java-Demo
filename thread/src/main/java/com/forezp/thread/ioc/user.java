package com.forezp.thread.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class user {

    @Autowired
    man man;

    public String queryName() {
        return man.getName();
    }
}
