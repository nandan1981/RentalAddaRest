package com.rentaladda.rent.controller;

import java.io.IOException;

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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentaladda.rent.dao.CustomerDAO;
import com.rentaladda.rent.model.Customer;

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
	private CustomerDAO customerDAO;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(value="/customers.htm",headers="Accept=*/*", produces={"application/json"})
	public String getCustomers() throws IOException {
		CustomerDAO cust = new CustomerDAO();
		try {
			System.out.println("in customersssssss");
		
			return mapper.writeValueAsString(cust.list());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getcustomerbyid/{id}",method = RequestMethod.GET, headers="Accept=*/*", produces={"application/json"})
	@ResponseBody
	public String getCustomer(@PathVariable("id") Long id) throws JsonProcessingException {

		Customer customer = customerDAO.get(id);
		if (customer == null) {
			return null;
		}

		return mapper.writeValueAsString(customer);
	}

	@PostMapping(value = "/customers")
	public Object createCustomer(@RequestBody Customer customer) {
		customerDAO.create(customer);
		return new ResponseEntity(customer, HttpStatus.OK);
	}


	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/customers/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Long id) {

		if (null == customerDAO.delete(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/customers/{id}")
	public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

		customer = customerDAO.update(id, customer);

		if (null == customer) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}

}