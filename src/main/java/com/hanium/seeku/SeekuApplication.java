package com.hanium.seeku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.hanium.seeku")
@SpringBootApplication
public class SeekuApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeekuApplication.class, args);
	}

}
