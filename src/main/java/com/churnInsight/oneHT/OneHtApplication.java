package com.churnInsight.oneHT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OneHtApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneHtApplication.class, args);
	}

}
