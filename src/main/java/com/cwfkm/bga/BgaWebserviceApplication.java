package com.cwfkm.bga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class BgaWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BgaWebserviceApplication.class, args);
	}

}
