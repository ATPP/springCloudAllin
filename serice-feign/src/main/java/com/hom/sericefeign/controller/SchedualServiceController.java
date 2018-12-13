package com.hom.sericefeign.controller;

import com.hom.sericefeign.service.impl.ISchedualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedualServiceController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    private ISchedualService schedualService;

    @RequestMapping("/hi")
    public String getService(@RequestParam(value = "name", defaultValue = "wing") String name){
       return schedualService.sayHiFromClientOne(name);
    }
}
