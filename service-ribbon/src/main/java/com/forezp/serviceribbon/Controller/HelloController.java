package com.forezp.serviceribbon.Controller;

import com.forezp.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String sayHello(@RequestParam("name") String name) {
        return helloService.sayHello(name);
    }
}
