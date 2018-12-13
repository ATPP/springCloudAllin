package com.hom.servicemonkey;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ServiceMonkeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMonkeyApplication.class, args);
    }

    private static final Logger logger = LoggerFactory.getLogger(ServiceMonkeyApplication.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/panda")
    public String home() {
        logger.info("panda is being called");
        return "i am service-monkey";
    }

    @RequestMapping(value = "/monkey")
    public String info() {
        logger.info("info is being called");
        //service-panda prot
        return restTemplate.getForObject("http://localhost:8763/info", String.class);
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }

}

