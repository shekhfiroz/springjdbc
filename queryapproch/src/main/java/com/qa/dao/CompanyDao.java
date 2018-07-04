package com.qa.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class CompanyDao {
	private final String SQL_COUNT_OF_COMPANY = "select count(1) from company";
	private final String 
	private JdbcTemplate jdbcTemplate;

	public CompanyDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
   
	/*1=> Method to count the total nos of companies*/
	public int CountOfCompany() {
		return jdbcTemplate.queryForObject(SQL_COUNT_OF_COMPANY,Integer.class);
	}
	
}
