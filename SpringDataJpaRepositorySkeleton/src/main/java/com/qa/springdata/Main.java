package com.qa.springdata;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.qa.beans.Animal;
import com.qa.beans.Owner;
import com.qa.configs.SpringConfig;
import com.qa.services.JPAService;

@SpringBootApplication
@ComponentScan(basePackages = { "com.qa.services" })
@EnableJpaRepositories(basePackages = { "com.qa.repositories" })
@org.springframework.boot.autoconfigure.domain.EntityScan(basePackages = { "com.qa.beans" })
public class Main implements CommandLineRunner {

	@Autowired
	private JPAService jpaService;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		// 6)
		// Add your code here

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		Owner alice = (Owner) context.getBean("alice");
		Owner bob = (Owner) context.getBean("bob");
		jpaService.saveOwners(alice,bob);
		
		Animal alpha = (Animal) context.getBean("alpha");
		alpha.setOwnerID(alice.getOwnerID());
		jpaService.saveAnimal(alpha);
		
		Animal beta = (Animal) context.getBean("beta");
		beta.setOwnerID(alice.getOwnerID());
		jpaService.saveAnimal(beta);
		
		Animal gamma = (Animal) context.getBean("gamma");
		gamma.setOwnerID(alice.getOwnerID());
		jpaService.saveAnimal(gamma);
		
		Animal epsilon = (Animal) context.getBean("epsilon");
		epsilon.setOwnerID(bob.getOwnerID());
		jpaService.saveAnimal(epsilon);
		
		Animal delta = (Animal) context.getBean("delta");
		delta.setOwnerID(bob.getOwnerID());
		jpaService.saveAnimal(delta);
		
		
		
		
				
		
		
		System.out.println("From DB");
		Iterable<Owner> dbOwners = jpaService.getAllOwners();
		
		for(Owner o : dbOwners){
			System.out.println(o);
		}
		
		Iterable<Animal> dbAnimals = jpaService.getAllAnimals();
		
		for(Animal o : dbAnimals){
			System.out.println(o);
		}
		
		
		System.out.println("Find Animal 1");
		System.out.println(jpaService.findById(1));

	}
}
