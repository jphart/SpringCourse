package com.qa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qa.configs.SpringConfig;
import com.qa.services.MyService;

public class App {

	public App(){
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		MyService myService = (MyService) context.getBean("myService");
		myService.createTable();
		
		
	}
	
	public static void main(String[] args) {
		new App();

	}
}