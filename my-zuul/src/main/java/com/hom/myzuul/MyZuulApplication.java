package com.hom.myzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackageClasses = IndexController.class)
public class MyZuulApplication {

    //    public static void main(String[] args) {
//        SpringApplication.run(MyZuulApplication.class, args);
//    }
    public static void main(String[] args) {
        new SpringApplicationBuilder(MyZuulApplication.class).properties("server.port=9090").run(args);
    }

}

