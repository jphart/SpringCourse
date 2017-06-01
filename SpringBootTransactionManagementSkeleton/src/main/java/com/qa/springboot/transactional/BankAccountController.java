package com.qa.springboot.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BankAccountController {

	@Autowired
	private BankAccountService bankService;
	
	
	@RequestMapping("/createAccounts")
	public void createAccounts()
	{
		bankService.createBeansAndSave();
	}
	
	@RequestMapping("/transferFunds")
	public void transferFunds()
	{
		
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
