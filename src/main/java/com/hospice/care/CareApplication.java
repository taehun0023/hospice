package com.hospice.care;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) 
public class CareApplication{
	public static void main(String[] args) {
		SpringApplication.run(CareApplication.class, args);
	}

}