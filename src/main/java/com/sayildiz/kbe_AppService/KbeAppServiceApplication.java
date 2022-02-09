package com.sayildiz.kbe_AppService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KbeAppServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KbeAppServiceApplication.class, args);
	}

}
