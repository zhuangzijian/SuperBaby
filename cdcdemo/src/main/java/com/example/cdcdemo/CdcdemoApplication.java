package com.example.cdcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class CdcdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdcdemoApplication.class, args);
	}

}
