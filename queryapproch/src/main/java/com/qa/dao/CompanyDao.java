package com.qa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.qa.bo.Companybo;

public class CompanyDao {
	private final String SQL_COUNT_OF_COMPANY = "select count(1) from company";
	private final String SQL_GET_COLUMN_VALUES = "select company_name from company where company_no like ?";
	private final String SQL_GET_COMPANY_ROW = "select * from company where company_no like ?";
	private final String SQL_GET_ALL_RECORDS_OF_COMPANY = "select * from company";
	private final String SQL_INSERT_INTO_COMPANY_TABLE="insert into company(company_no,company_name,description,established_date,location) values(?,?,?,?,?)";
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
	public Companybo getCompanyRowObject(int company_no) {

		return jdbcTemplate.queryForObject(SQL_GET_COMPANY_ROW, new CompanyRowMapper(), company_no);

	}

	/* inner class get 1 complete row from database and set to the java class */
	private static final class CompanyRowMapper implements RowMapper<Companybo> {

		@Override
		public Companybo mapRow(ResultSet rs, int rowNum) throws SQLException {
			Companybo cbo = new Companybo();
			cbo.setCompany_nos(rs.getString(1));
			cbo.setCompany_name(rs.getString(2));
			cbo.setDescription(rs.getString(3));
			cbo.setEstablished_Date(rs.getString(4));
			cbo.setLocation(rs.getString(5));
			return cbo;
		}
	}

	/* 4=> to get multiple row of records from table */
	public List<Companybo> getAllCompanyRecords() {
		/* calling query() method to get all records */
		return jdbcTemplate.query(SQL_GET_ALL_RECORDS_OF_COMPANY, new CompanyRowMapper());
	}

	/* inserting records into table */
	public int insertrecords(int company_no,String company_name,String description,String established_date,String location) {
		return jdbcTemplate.update(SQL_INSERT_INTO_COMPANY_TABLE,company_no,company_name,description,established_date,location);
		
	}
}
