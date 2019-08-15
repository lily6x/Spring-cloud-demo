package com.lily.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 标志此类为Spring boot 的启动类
@SpringBootApplication
// 开启此服务可被发现
@EnableEurekaClient
// 启动Feign 模式消费服务
@EnableFeignClients
// 启动熔断器
@EnableHystrix
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
