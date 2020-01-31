package com.forezp.servicefeign.Interface;

import com.forezp.servicefeign.Interface.impl.SayHiFeignInterfaceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
@FeignClient(value = "SERVICE-HI",fallback = SayHiFeignInterfaceImpl.class)
public interface SayHiFeignInterface {

    @GetMapping(value = "/hi")
    String sayHi(@RequestParam(value = "name") String name);
}
