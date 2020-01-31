package com.forezp.servicefeign.Interface.impl;

import com.forezp.servicefeign.Interface.SayHiFeignInterface;
import org.springframework.stereotype.Component;

@Component
public class SayHiFeignInterfaceImpl implements SayHiFeignInterface {

    @Override
    public String sayHi(String name) {
        return "hi" + name + ",this service is error";
    }
}
