package com.qa.springboot.transactional;

public class InsufficientBalanceException extends Exception {
	
	double amount, currentBalance;
	
	public InsufficientBalanceException(double amount, double currentBalance){
		this.amount = amount;
		this.currentBalance = currentBalance;
	}
	
	public String getMessage(){
		return "Insufficient Balance Exception: Attempted to remove " + amount + " but only " + currentBalance + " available";
	}
}