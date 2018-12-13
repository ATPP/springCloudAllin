package com.hom.servicepanda;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServicePandaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePandaApplication.class, args);
	}

	private static final Logger logger = LoggerFactory.getLogger(ServicePandaApplication.class);

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/panda")
	public String home(@RequestParam(value = "name", defaultValue = "hom") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}

	@RequestMapping("/call")
	public String callHome(){
		logger.info("calling trace service-panda");
		return restTemplate.getForObject("http://localhost:8989/panda", String.class);
	}

	@RequestMapping("/info")
	public String info(){
		logger.info("calling trace service-panda");
		return "i am service-panda";
	}

	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}

}
