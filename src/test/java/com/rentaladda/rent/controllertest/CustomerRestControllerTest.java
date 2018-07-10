package com.rentaladda.rent.controllertest;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rentaladda.rent.controller.CustomerRestController;
import com.rentaladda.rent.dao.CustomerDAO;
import com.rentaladda.rent.model.Customer;

/**
 * 
 * CustomerRestControllerTest.class
 * 
 * @author Nandan Subramanian
 * This Test class tests the controller class
 * 
 */

public class CustomerRestControllerTest {

	private CustomerRestController custRestCtrl;
	
	@Mock
	private CustomerDAO customerDAO;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	//@Test(expected = RuntimeException.class)
	@Test
	public void testWhenWrongNumberOfParametersAreSent() {
		Assert.assertEquals(CustomerRestController.addNumbers(10, 30),40);
		assertTrue(true);
	}
	
	@Test
	public void testTheGetMethodFromDAO() throws JsonProcessingException {
		Customer cust = new Customer();
		
		when(customerDAO.get(1L)).thenReturn(cust);
		
		//String str = custRestCtrl.getCustomer(1L);
		
		//verify(customerDAO.get(1L));
	}

}