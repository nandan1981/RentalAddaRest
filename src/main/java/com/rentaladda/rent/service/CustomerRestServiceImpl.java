package com.rentaladda.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rentaladda.rent.dao.CustomerDAOImpl;
import com.rentaladda.rent.model.Customer;

public class CustomerRestServiceImpl implements CustomerRestService {
	
	@Autowired
	public CustomerDAOImpl custDao;

	@Override
	public List list() {
		return custDao.list();
	}

	@Override
	public boolean insert(Customer cust) {
		return false;
	}

	@Override
	public boolean update(Integer id, Customer cust) {
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		return false;
	}
	
	public void setCustomerDAOImpl(CustomerDAOImpl custDao) {
		this.custDao = custDao;
	}

	public Integer count() {
		return custDao.count();
	}

}
