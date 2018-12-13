package com.hom.serviceribbon.service.impl;

import com.hom.serviceribbon.service.IHelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DefaultHelloService implements IHelloService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 加上@HystrixCommand注解。该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法，
     * 这就说明当 service-panda 工程不可用的时候，service-ribbon调用 service-panda的API接口时，会执行快速失败
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "toError")
    @Override
    public String getService(String name) {
        return restTemplate.getForObject("http://SERVICE-PANDA/panda?name=" + name, String.class);
    }

    public String toError(String name) {
        return "the " + name + " have error";
    }

}
