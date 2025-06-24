package com.github.osvaldsoza.hrapigatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HrApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApiGatewayApplication.class, args);
	}

}
