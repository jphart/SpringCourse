package com.qa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.qa.beans.Owner;
import com.qa.beans.Pet;
import com.qa.beans.PropertyBean;

@Configuration
@PropertySource("classpath:my.properties")
public class SpringConfig {

	@Value("${key1}")
	private String key1;

	@Value("${key2}")
	private String key2;

	@Bean
	public Pet pet1Bean() {
		Pet pet = new Pet();
		pet.setName("Daisy");
		return pet;
	}

	@Bean
	public Pet pet2Bean() {
		return new Pet("Lola");
	}

	@Bean
	public Pet pet3Bean() {
		return new Pet("Lassie");
	}

	@Bean
	public Owner ownerBean() {
		Owner owner = new Owner();
		owner.setName("Joe");

		List<Pet> pets = new ArrayList<Pet>();
		pets.add(this.pet1Bean());
		pets.add(this.pet2Bean());
		pets.add(this.pet3Bean());

		owner.setPets(pets);

		return owner;
	}
	
	@Bean
	public PropertyBean propertyBean(){
		PropertyBean pb = new PropertyBean();
		pb.key1 = this.key1;
		pb.key2 = this.key2;
		
		return pb;
	}

	// To resolve ${} in @Value
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
