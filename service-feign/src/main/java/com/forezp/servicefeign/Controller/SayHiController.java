package com.forezp.servicefeign.Controller;

import com.forezp.servicefeign.Interface.SayHiFeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHiController {

    @Autowired
    SayHiFeignInterface sayHiFeignInterface;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam("name") String name) {
        return sayHiFeignInterface.sayHi(name);
    }
}
