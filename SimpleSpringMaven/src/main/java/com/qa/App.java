package com.qa;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qa.beans.Owner;
import com.qa.beans.Pet;
import com.qa.beans.PropertyBean;

public class App {

	public App(){
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		//Get pets
		Map<String,Pet> list = new HashMap<String,Pet>(context.getBeansOfType(Pet.class));
		for(Pet p : list.values()){
			System.out.println(p.getName());
		}
		
		Owner owner = (Owner) context.getBean("ownerBean");
		System.out.println(owner.getName());
		System.out.println(owner);
		
		PropertyBean propertyBean = (PropertyBean) context.getBean("propertyBean");
		System.out.println(propertyBean);
		
//		
//		//Java8
//		list.forEach((k,v) -> System.out.println(v.getName()));
		
		
		
	}
	
	public static void main(String[] args) {
		new App();

	}

}
