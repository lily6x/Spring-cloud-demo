package com.lily.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service-hello")
public interface HelloService2 {

    @GetMapping(value = "/hi")
    String hi();
}
