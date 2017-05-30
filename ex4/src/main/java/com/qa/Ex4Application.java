package com.qa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qa.beans.Customer;
import com.qa.repository.CustomerRepository;

@SpringBootApplication
public class Ex4Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Ex4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Customers: ");
		for(Customer customer : customerRepository.findAllCustomers()){ System.out.println(customer);}
		
		customerRepository.addCustomer(105, "Jon", "Leamington");
		
		System.out.println("Customers: ");
		for(Customer customer : customerRepository.findAllCustomers()){ System.out.println(customer);}
		
		System.out.println("Jon:");
		System.out.println(customerRepository.findCustomerById(105));
		
		System.out.println("Jon moved:");
		customerRepository.updateCustomerAddressById("Durham", 105);
		System.out.println(customerRepository.findCustomerById(105));

		
		System.out.println("Jon deleted");
		customerRepository.deleteCustomerById(105);
		
		System.out.println("Customers: ");
		for(Customer customer : customerRepository.findAllCustomers()){ System.out.println(customer);}	
		
	}
}
