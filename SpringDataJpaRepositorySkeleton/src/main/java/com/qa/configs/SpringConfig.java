package com.qa.configs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qa.beans.Animal;
import com.qa.beans.Owner;

@Configuration
public class SpringConfig {

	
	private Date getDate(String dateStr){
		try {
			return new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
		} catch (ParseException e) {
			return new Date();
		}
	}
	
	//beans for five animals
	@Bean
	public Animal alpha(){
		return new Animal(0, "Alpha", "Dog", getDate("10-01-2014"));//, alice());
	}
	
	@Bean
	public Animal beta(){
		return new Animal(1, "Beta", "Dog", getDate("15-01-2014"));//, alice());
	}
	
	@Bean
	public Animal gamma(){
		return new Animal(2, "Gamma", "Cat", getDate("08-03-2008"));//, bob());
	}
	
	@Bean
	public Animal delta(){
		return new Animal(3, "Delta", "Cat", getDate("09-01-2009"));//, bob());
	}
	
	@Bean
	public Animal epsilon(){
		return new Animal(4, "Epsilon", "Rabbit", getDate("20-03-2013"));//, bob());
	}
	
	/* 4 a) Create/Configure two Owner beans,
	  each owning at least two Animal beans.
	 */
	// Add your code here
	
	@Bean
	public Owner alice(){
		Owner alice = new Owner(0,"Alice","alice@example.com");
		alice.addAnimal(this.alpha());
		alice.addAnimal(this.beta());
		return alice;
	}
	
	@Bean
	public Owner bob(){
		Owner bob = new Owner(0,"Bob","bob@example.com");
		bob.addAnimal(this.gamma());
		bob.addAnimal(this.delta());
		bob.addAnimal(this.epsilon());
		return bob;
	}
}
