package com.rentaladda.rent.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentaladda.rent.dao.CustomerDAOImpl;
import com.rentaladda.rent.model.Customer;
import com.rentaladda.rent.service.CustomerRestServiceImpl;

/**
 * 
 * CustomerRestController.class
 * 
 * @author Nandan Subramanian
 * This controller class returns the customers present in RentalAdda Database
 * 
 */

@RestController
@Component
@EnableWebMvc
public class CustomerRestController {

	@Autowired
	private CustomerRestServiceImpl service;
	
	ObjectMapper mapper = new ObjectMapper();
	
	private final Logger logger = LoggerFactory.getLogger(CustomerRestController.class);
	
	@RequestMapping(value="/customers.htm", method = RequestMethod.GET,headers="Accept=*/*", produces={"application/json"})
	public String getCustomers() throws IOException {
		
		try {
logger.info("in customersssssss");
			return mapper.writeValueAsString(service.list());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value="/customerCount.htm", method = RequestMethod.GET,headers="Accept=*/*", produces={"application/json"})
	public String getCustomerCount() throws IOException {
		
		try {
			return mapper.writeValueAsString(service.count());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param id
	 * @return
	 */
//	@RequestMapping(value="/getcustomerbyid/{id}",method = RequestMethod.GET, headers="Accept=*/*", produces={"application/json"})
//	@ResponseBody
/*	public String getCustomer(@PathVariable("id") Long id) throws JsonProcessingException {

		Customer customer = customerDAO.get(id);
		if (customer == null) {
			return null;
		}

		return mapper.writeValueAsString(customer);
	}*/

	@PostMapping(value = "/customers")
	public Object createCustomer(@RequestBody Customer customer) {
		boolean resp = service.insert(customer);
		
		if(resp == true) {
			return new ResponseEntity(customer, HttpStatus.OK);
		}else {
			return new ResponseEntity(customer, HttpStatus.METHOD_FAILURE);
		}
	}


	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/customers/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Integer id) {
		if (false == service.delete(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(id, HttpStatus.OK);
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {

		boolean resp = service.update(id, customer);

		if (null == customer) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		} else if(resp == false) {
			return new ResponseEntity("The update failed for ID " + id, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}
	
	public static int addNumbers(int x, int y) {
		return x+y;
	}
	
	public void setCustomerService(CustomerRestServiceImpl service) {
		this.service = service;
	}

}