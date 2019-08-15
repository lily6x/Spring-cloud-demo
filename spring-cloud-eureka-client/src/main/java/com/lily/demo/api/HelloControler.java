package com.lily.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hi")
    public String hi(){
        return "hi demo , I 'm from port : " + port;
    }

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello demo , I 'm from port : " + port;
    }

}
