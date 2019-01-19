package com.hom.wzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ServletComponentScan(basePackageClasses = ZuulController.class)
public class WZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(WZuulApplication.class, args);
    }
}

