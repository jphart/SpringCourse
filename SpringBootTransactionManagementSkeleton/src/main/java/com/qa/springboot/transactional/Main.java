package com.qa.springboot.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner{

	
	@Autowired
	private BankAccountService bankService;
	
	
	private boolean createAccounts = false;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		// Creates two new bank accounts 
		if(createAccounts)
		{
			bankService.createBeansAndSave();
			
		}
		
		BankAccount a = bankService.getAccountByID(1L);
		BankAccount b = bankService.getAccountByID(2L);
		// print out the values in the account
		System.out.println("*** BEFORE ***");
		System.out.println(a);
		System.out.println(b);

		// try to move money from one account to the other
		try {
				bankService.transferFunds(a, b, 50.0);
			} catch (InsufficientBalanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		// get the bank account beans from the database
		a = bankService.getAccountByID(1L);
		b = bankService.getAccountByID(2L);

		System.out.println("*** AFTER ***");
		System.out.println(a);
		System.out.println(b);
	
		
		
	}
	
	
	
}
