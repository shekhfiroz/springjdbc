package com.qa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.qa.bo.Companybo;

public class CompanyDao {
	private final String SQL_COUNT_OF_COMPANY = "select count(1) from company";
	private final String SQL_GET_COLUMN_VALUES = "select company_name from company where company_no like ?";
	private final String SQL_GET_COMPANY_ROW = "select * from company where company_no like ?";

	private JdbcTemplate jdbcTemplate;

	public CompanyDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/* 1=>Method to count the total nos of companies */
	public int CountOfCompany() {
		return jdbcTemplate.queryForObject(SQL_COUNT_OF_COMPANY, Integer.class);
	}

	/* 2=>Method to return companies column */
	public String getCompanyName(int company_no) {
		return jdbcTemplate.queryForObject(SQL_GET_COLUMN_VALUES, String.class, company_no);
	}

	/* 3=> return a complete row as an object */
	public CompanyBo getCompanyRowObject(int company_no) {
		

		return jdbcTemplate.queryForObject(SQL_GET_COMPANY_ROW, String.class, company_no);

	}

	private static final class CompanyRowMapper implements RowMapper<Companybo>

		@Override
		public Companybo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return null;
		}
}
