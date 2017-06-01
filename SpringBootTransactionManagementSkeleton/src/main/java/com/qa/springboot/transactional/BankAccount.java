package com.qa.springboot.transactional;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {
	
	@Id
	private long id;
	private double balance;
	
	public BankAccount(long id, double balance){
		this.id = id;
		this.balance = balance;
	}
	
	public BankAccount(){}
	
	public long getID(){
		return id;
	}
	
	public void setID(long id){
		this.id = id;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void increment(double amount){
		balance = balance + amount;
	}
	
	public void decrement(double amount) throws InsufficientBalanceException {
		if (balance >= amount){
			balance = balance - amount;
		} else {
			throw new InsufficientBalanceException(amount, balance);
		}
	}
	
	@Override
	public String toString(){
		return id + ": " + balance;
	}
}
