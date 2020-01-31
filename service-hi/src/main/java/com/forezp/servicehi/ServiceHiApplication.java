package com.forezp.servicehi;

import com.google.common.base.Preconditions;
import com.netflix.discovery.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run( ServiceHiApplication.class, args );
    }

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String home(@RequestParam(value = "name") String name) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name));
        return "hi " + name + " ,i am from port:" + port;
    }

}



