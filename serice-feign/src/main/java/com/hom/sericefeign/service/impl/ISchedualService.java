package com.hom.sericefeign.service.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义一个feign接口，通过@ FeignClient（“服务名”），来指定调用哪个服务。比如在代码中调用了service-panda服务的“/panda”接口
 */
@FeignClient(value = "service-panda", fallback = SchedualServiceHystric.class)
public interface ISchedualService {

    @RequestMapping(value = "/panda", method = RequestMethod.GET)
    public String sayHiFromClientOne(@RequestParam(value = "name", defaultValue = "wing") String name);
}
