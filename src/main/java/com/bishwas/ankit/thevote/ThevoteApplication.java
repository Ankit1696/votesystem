package com.bishwas.ankit.thevote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bishwas.ankit.thevote.repository")
@ComponentScan(basePackages = "com.bishwas.ankit.thevote.service")
public class ThevoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThevoteApplication.class, args);
	}

}
