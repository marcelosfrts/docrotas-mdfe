package com.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class AppServer {

	public static void main(String[] args) {
		SpringApplication.run(AppServer.class, args);
	}
	
	@RequestMapping("/home")
	public String hello() {
		return "Welcome!";
	}	

}
