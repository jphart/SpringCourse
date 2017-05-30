package com.qa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qa.services.MyService;

@SpringBootApplication
public class JdbcTemplateWithSpringBootApplication implements CommandLineRunner{

	@Autowired
	private MyService myService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateWithSpringBootApplication.class, args);
		
		
	}


	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(myService.createTable() + "records created");
		
	}
}
