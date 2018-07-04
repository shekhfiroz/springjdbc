package com.classicapproch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.classicapproch.bo.Companybo;

public class CompanyDao {
	private JdbcTemplate jdbcTemplate;

	private final String SQL_SELECT_COMPANIES = "select * from company where company_name like ?";

	public CompanyDao(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	// our method to execute the functionality.
	public List<Companybo> findCompnyByName(String companyName) {

		// have to pass company_name argument into this methods
		CompanyFindByNameCreater cfbnc = new CompanyFindByNameCreater(companyName);
		CompanyFindByNameCallBack cfnb = new CompanyFindByNameCallBack();
		return jdbcTemplate.execute(cfbnc, cfnb);
	}

	// creater method
	private final class CompanyFindByNameCreater implements PreparedStatementCreator {
		PreparedStatement pstmt = null;
		String companyName;

		public CompanyFindByNameCreater(String companyName) {
			this.companyName = companyName;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			pstmt = con.prepareStatement(SQL_SELECT_COMPANIES);
			pstmt.setString(1, "%" + companyName + "%");
			return pstmt;
		}

	}

	// callback method
	private final class CompanyFindByNameCallBack implements PreparedStatementCallback<List<Companybo>> {

		@Override
		public List<Companybo> doInPreparedStatement(PreparedStatement pstmt) throws SQLException, DataAccessException {
			ResultSet rs = null;
			List<Companybo> companybo = null;
			Companybo cbo = null;

			rs = pstmt.executeQuery();
			companybo = new ArrayList<>();

			while (rs.next()) {
				cbo = new Companybo();
				cbo.setCompany_nos(rs.getString("company_no"));
				cbo.setCompany_name(rs.getString("company_name"));
				cbo.setDescription(rs.getString("description"));
				cbo.setEstablished_Date(rs.getString("established_Date"));
				cbo.setLocation(rs.getString("location"));

				// adding to the above declared array list object
				companybo.add(cbo);
			}
			return companybo;
		}

	}

}
