package com.rentaladda.rent.service;

import java.util.List;

import com.rentaladda.rent.model.Customer;

public interface CustomerRestService {
	
	public List list();
	
	public boolean insert(Customer cust);
	
	public boolean update(Integer id , Customer cust);
	
	public boolean delete(Integer id);

	public Integer count();

}
