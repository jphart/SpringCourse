package com.qa.springboot.transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankAccountService {
	@Autowired
	BankAccountRepository bankAccountRepository;

	/*
	 * Simple helper method to create some beans and save them to the database.
	 * Call this to initialise everything
	 */
	public void createBeansAndSave() {
				
		bankAccountRepository.save(new BankAccount(0, 50));
		bankAccountRepository.save(new BankAccount(1, 50));
	
	}

	public Iterable<BankAccount> getAllAccounts() {

		// Write your code to fetch all accounts
		return bankAccountRepository.findAll();
	}

	public BankAccount getAccountByID(long id) {
	
		return bankAccountRepository.findOne(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class )
	public void transferFunds(BankAccount fromAccount, BankAccount toAccount, final Double transferAmount) throws InsufficientBalanceException{
		
		if(fromAccount.getBalance() > transferAmount){
			throw new InsufficientBalanceException(transferAmount, fromAccount.getBalance());
		}
		
		fromAccount.decrement(transferAmount);
		toAccount.increment(transferAmount);
		
		bankAccountRepository.save(fromAccount);
		bankAccountRepository.save(toAccount);
		
		
	}


}

