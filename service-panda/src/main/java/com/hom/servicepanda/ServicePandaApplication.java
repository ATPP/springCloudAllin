package com.hom.servicepanda;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServicePandaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePandaApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/panda")
	public String home(@RequestParam(value = "name", defaultValue = "hom") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}
}
