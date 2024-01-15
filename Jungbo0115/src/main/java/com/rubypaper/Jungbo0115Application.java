package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.rubypaper.project", "com.rubypaper.controller" })
public class Jungbo0115Application {

	public static void main(String[] args) {
		SpringApplication.run(Jungbo0115Application.class, args);
	}

}
