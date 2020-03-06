package com.forezp.thread.exam;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class testController {

    @GetMapping(value = "/data")
    public String getData(DestData destData) {
        System.gc();
        return destData.getName();
    }



}
