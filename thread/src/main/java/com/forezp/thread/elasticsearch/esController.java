package com.forezp.thread.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

public class esController {

    @Autowired
    ElasticsearchRestTemplate elRestTemplate;

    public void name() {
        System.out.println("你好");
    }
}
