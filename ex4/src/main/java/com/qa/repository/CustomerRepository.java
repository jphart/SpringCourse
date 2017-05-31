package com.qa.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.qa.beans.Customer;

@Repository
public class CustomerRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addCustomer(int customerId, String name, String address){
		jdbcTemplate.update("INSERT INTO customer(customerId, name, address) values (?,?,?)", new Object[]{customerId,name,address});
	}
	
	public int updateCustomerAddressById(String address, int customerId){
		return jdbcTemplate.update("UPDATE customer set address = ? where customerId = ?", new Object[]{address,customerId});
	}
	
	public Customer findCustomerById(int customerId){
		
		String sql = "SELECT * FROM customer where customerId = ?";
		
		Customer customer = (Customer) jdbcTemplate.queryForObject(sql, new Object[]{customerId}, new CustomerRowMapper());
		
		return customer;
	}
	
	public List<Customer> findAllCustomers(){
		
		return jdbcTemplate.query("select * from customer", new CustomerRowMapper());
	}
	
	public int deleteCustomerById(int customerId){
		return jdbcTemplate.update("DELETE from customer where customerId = ?", new Object[]{customerId});
	}
	
}
