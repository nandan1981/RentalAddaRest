package com.rentaladda.rent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rentaladda.rent.model.Customer;

public class CustomerRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				Customer customer = new Customer();
				customer.setId(rs.getInt("CUST_ID"));
				customer.setFirstName(rs.getString("FIRST_NAME"));
				customer.setLastName(rs.getString("LAST_NAME"));
				customer.setEmail(rs.getString("EMAIL"));
				//customer.setAge(rs.getInt("AGE"));
				return customer;			
				
	}
	
}
