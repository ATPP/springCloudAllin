package com.hom.sericefeign.service.impl;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHystric implements ISchedualService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "the "+ name + " error";
    }
}
