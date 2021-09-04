package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class DemoRestTaskApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoRestTaskApplication.class, args);
	}
}
