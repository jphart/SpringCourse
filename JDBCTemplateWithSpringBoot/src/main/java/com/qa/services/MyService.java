package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int createTable(){
		return jdbcTemplate.update("INSERT INTO employee (id, name) values (1,'Jon')");
	}
	
}
