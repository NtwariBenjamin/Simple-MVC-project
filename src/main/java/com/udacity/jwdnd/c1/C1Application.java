package com.udacity.jwdnd.c1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class C1Application {

	public static void main(String[] args) {
		SpringApplication.run(C1Application.class, args);
	}
//	@Bean
//	public String message(){
//		System.out.println("Creating Bean Message");
//		return "Hello, Spring";
//	}
//	@Bean
//	public String upperCaseMessage(MessageService messageService){
//		System.out.println("Creating Bean Message");
//		return messageService.upperCaseMessage();
//	}
//	@Bean
//	public String lowerCaseMessage(MessageService messageService){
//		System.out.println("Creating Bean Message");
//		return messageService.lowerCaseMessage();
//	}
}

