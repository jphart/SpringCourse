package com.qa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qa.configs.SpringConfig;


public class App {

	public App(){
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
	}
	
	
	
}
