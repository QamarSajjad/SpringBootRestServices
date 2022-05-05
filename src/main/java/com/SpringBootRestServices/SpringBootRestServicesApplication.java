package com.SpringBootRestServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.SpringBootRestServices.UserController")
public class SpringBootRestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestServicesApplication.class, args);
		
	}

}
