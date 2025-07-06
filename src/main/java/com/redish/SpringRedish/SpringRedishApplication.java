package com.redish.SpringRedish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication

@EnableCaching
public class SpringRedishApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedishApplication.class, args);
	}

}
