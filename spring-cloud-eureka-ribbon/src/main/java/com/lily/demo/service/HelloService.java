package com.lily.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String HiService(String name){
        System.out.println(restTemplate.toString());
        String s = "";
        try {
            s = restTemplate.getForObject("http://service-hi/hi",String.class);
        } catch (RestClientException e) {
            System.out.println("调用微服务失败!");
            s = e.getMessage();
        }
        return s;
    }
}
