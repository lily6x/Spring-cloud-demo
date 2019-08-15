package com.lily.demo.api;

import com.lily.demo.service.HelloService;
import com.lily.demo.service.HelloService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费者 控制器 ， 对外提供访问入口
 */
@RestController
public class HelloControler {

    /**
     * 注入 Feign 接口， 容器会自动注入真实的服务提供者
     */
    @Autowired
    HelloService helloService;

    @Autowired
    HelloService2 helloService2;

    /**
     * 服务消费入口， 由此入口消费在注册中心注册的服务
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sayHi")
//    @HystrixCommand(fallbackMethod = "hiFallbackMethod")
    public String hi() throws Exception{
        return helloService.HiService("test");
    }

//    public String hiFallbackMethod(){
//        return "hi 服务调用失败，已被熔断器捕获！ ";
//    }

    @RequestMapping(value = "/sayHello")
    public String hello() throws Exception{
        return helloService.helloService("test");
    }

    @RequestMapping(value = "/hi")
    public String hi2(){
        return helloService2.hi();
    }

}
