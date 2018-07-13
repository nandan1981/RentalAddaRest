package com.rentaladda.rent.daotest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.mockito.junit.*;
import org.mockito.runners.MockitoJUnitRunner;

import com.rentaladda.rent.dao.CustomerDAO;
import com.rentaladda.rent.model.Customer;


@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = {
     "classpath*:RentalAddaRest-config.xml",
     "classpath*:dataSource-Config.xml"
})
public class CustomerDAOTest {
	
	 @Autowired
	 @InjectMocks
	 private CustomerDAO customerDAO;
	 
	 
	 @Mock
	 private JdbcTemplate jdbcTemplate;
	 
	 @Before
	 public void setUp() {
		 MockitoAnnotations.initMocks(this);
	 }
	
	// Dummy database. Initialize with some dummy values.t
	    @Test
		public void TestNotEmptyCustomersList()
		{
			ArrayList<Customer> customers = new ArrayList();
			customers.add(new Customer(101, "John", "Doe", "djohn@gmail.com", "121-232-3435"));
			customers.add(new Customer(201, "Russ", "Smith", "sruss@gmail.com", "343-545-2345"));
			
			assertFalse(customers.isEmpty());
		}

	    @Test
		public void TestEmptyCustomersList()
		{
			ArrayList<Customer> customers = new ArrayList();
			assertTrue(customers.isEmpty());
		}
	

/*	    @SuppressWarnings("unchecked")
		@Test
	    public void getCustomers() {
	    	
	    	final String expectedSql = "SELECT * FROM Customer WHERE id=?";
	    	   final long CUSTOMER_ID = 1;
	    	   final Customer expectedCustomer = new Customer();
	    	       { expectedCustomer.setId(CUSTOMER_ID);
	    	       expectedCustomer.setFirstName("ABC");
	    	       expectedCustomer.setLastName("TestName"); };
	    	   when(jdbcTemplate.query(eq(expectedSql),
	    	       any(ResultSetExtractor.class), eq(CUSTOMER_ID)))
	    	       .thenReturn(expectedCustomer);
	    	   Assert.assertNotNull(customerDAO);
	    	   Customer returnedCustomer = customerDAO.get(CUSTOMER_ID);
	    	   verify(jdbcTemplate).query(eq(expectedSql),
	    	       any(ResultSetExtractor.class), eq(CUSTOMER_ID));
	    	   Assert.assertEquals(expectedCustomer, returnedCustomer);
	    	 }*/
	    	
	    
}
