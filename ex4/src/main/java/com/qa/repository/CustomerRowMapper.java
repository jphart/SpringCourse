package com.qa.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.qa.beans.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		
		customer.setCustomerId(rs.getInt("customerId"));
		customer.setName(rs.getString("name"));
		customer.setAddress(rs.getString("address"));
		
		return customer;
	}

}
