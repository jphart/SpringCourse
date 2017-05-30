package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void createTable(){
		jdbcTemplate.execute("CREATE table employee(id int primary key, name varchar(30))");
	}
}
