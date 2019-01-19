package com.hom.wzuul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuulController {

    @RequestMapping("/zuul")
    public String index() {
        return "go to 9090";
    }
}

