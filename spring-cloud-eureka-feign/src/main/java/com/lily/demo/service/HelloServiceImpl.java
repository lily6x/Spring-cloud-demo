package com.lily.demo.service;

import org.springframework.stereotype.Component;

/**
 * Feign 回调类
 * 需实现Feign 接口，在重写方法中实现回调后需要执行的代码
 */
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String HiService(String name) {
        return "Get hiService Failed !";
    }

    @Override
    public String helloService(String name) {
        return "Get helloService Failed !";
    }
}
