package com.rentaladda.rent.controller;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentaladda.rent.dao.CustomerDAO;
import com.rentaladda.rent.model.Customer;

/**
 * 
 * CustomerRestControllerTest.class
 * 
 * @author Nandan Subramanian
 * This controller Test class tests the operations done on customers present in RentalAdda Database
 * 
 */

@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:**/RentalAddaRest-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerRestControllerTest {

	@Autowired
	private CustomerDAO customerDAO;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
    private WebApplicationContext wac;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	public void getCustomers() throws IOException {
		CustomerDAO cust = new CustomerDAO();
		
	}

	public void getCustomer() throws JsonProcessingException {
		Long id= null;
		Customer customer = customerDAO.get(id);
	}

	@Test
	public void TestCreateCustomer() {
		Customer customer = new Customer();
		customerDAO.create(customer);
	}

	/**vv
     *
	 */
	@Test
	public void TestDeleteCustomer() {
		Long id = null ;
		customerDAO.delete(id);
	}

	@Test
	public void updateCustomer() {
		Long id = null;
		Customer customer = new Customer();
		customerDAO.update(id, customer);
	}

}