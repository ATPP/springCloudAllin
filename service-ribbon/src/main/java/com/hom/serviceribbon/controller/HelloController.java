package com.hom.serviceribbon.controller;

import com.hom.serviceribbon.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @RequestMapping("/hi")
    public String getService(@RequestParam(value = "name", defaultValue = "wing") String name){
       return helloService.getService(name);
    }
}
