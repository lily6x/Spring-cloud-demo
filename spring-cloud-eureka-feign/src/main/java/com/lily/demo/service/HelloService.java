package com.lily.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 通过使用FeignClient 来消费服务
 * GetMapping : 服务中的具体方法 ，服务提供者中的不同 url 地址
 * value ： 服务名称
 * fallback : 回调类
 */
@FeignClient(value = "service-hi",fallback = HelloServiceImpl.class)
public interface HelloService {

    @GetMapping("/hi")
    String HiService(String name) throws Exception;

    @GetMapping("/hello")
    String helloService(String name) throws Exception;
}
