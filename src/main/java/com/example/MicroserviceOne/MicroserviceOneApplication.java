package com.example.MicroserviceOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOneApplication.class, args);
	}

}
