package com.rubypaper;

// import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.rubypaper", "com.controller" })
// @MapperScan("com.rubypaper.project")
public class Jungbo0115Application {

	public static void main(String[] args) {
		SpringApplication.run(Jungbo0115Application.class, args);
	}

}
