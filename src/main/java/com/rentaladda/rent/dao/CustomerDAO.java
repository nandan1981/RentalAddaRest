package com.rentaladda.rent.dao;

import java.util.List;

import com.rentaladda.rent.model.Customer;

public interface CustomerDAO {

	
	public List<Customer> list();
	
	public boolean insert(Customer customer);
	
	public boolean delete(Long id);
	
	public boolean update(Long id, Customer customer);
	
	public Integer count();
	
}
