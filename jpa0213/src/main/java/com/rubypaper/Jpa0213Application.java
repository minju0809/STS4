package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.rubypaper","com.controller"})
public class Jpa0213Application {

	public static void main(String[] args) {
		SpringApplication.run(Jpa0213Application.class, args);
	}

}
