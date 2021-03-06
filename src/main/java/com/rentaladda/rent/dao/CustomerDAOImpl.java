package com.rentaladda.rent.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rentaladda.rent.model.Customer;

@Repository
public class CustomerDAOImpl {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	// Dummy database. Initialize with some dummy values.
		private static List<Customer> customers;
		{
			customers = new ArrayList();
			customers.add(new Customer(101, "John", "Doe", "djohn@gmail.com", "121-232-3435"));
			customers.add(new Customer(201, "Russ", "Smith", "sruss@gmail.com", "343-545-2345"));
			customers.add(new Customer(301, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987"));
			customers.add(new Customer(401, "John", "connor", "djohnconnor@gmail.com", "131-232-3435"));
			customers.add(new Customer(501, "Russel", "Crowe", "srussellcrowe@gmail.com", "353-545-2345"));
			customers.add(new Customer(601, "Kate", "Winslet", "kwinslet@gmail.com", "976-237-2987"));
			customers.add(new Customer(701, "John", "pope", "djohn@gmail.com", "121-232-3435"));
			customers.add(new Customer(801, "Steve", "Smith", "steveruss@gmail.com", "343-545-2345"));
			customers.add(new Customer(901, "Kate", "Blanchett", "kwilliams@gmail.com", "866-237-2987"));
		}

		/**
		 * Returns list of customers from dummy database.
		 * 
		 * @return list of customers
		 */
		public List<Customer> list() {
/*			THIS IS TO GET A PARTICULAR CUSTOMER
 * 			int custId = 1;
			String sql = "SELECT FIRST_NAME FROM CUSTOMER WHERE CUSTOMER_ID = ?";
			String name = (String)jdbcTemplate.queryForObject(
					sql, new Object[] { custId }, String.class);*/
			
			
			String query = "select * from customer";
			
			List<Customer> customers = new ArrayList<Customer>();
			
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
			for (Map row : rows) {
				Customer customer = new Customer();
				customer.setId((Integer)(row.get("CUSTOMER_ID")));
				customer.setFirstName((String)row.get("FIRST_NAME"));
				customer.setLastName((String)row.get("LAST_NAME"));
				customer.setEmail((String)row.get("EMAIL"));		
				customers.add(customer);
			}
			return customers;
		}

		/**
		 * Return customer object for given id from dummy database. If customer is
		 * not found for id, returns null.
		 * 
		 * @param cUSTOMER_ID
		 *            customer id
		 * @return customer object for given id
		 */
		public Customer get(Integer cUSTOMER_ID) {

			for (Customer c : customers) {
				if (c.getId().equals(cUSTOMER_ID)) {
					return c;
				}
			}
			return null;
		}

		/**
		 * Create new customer in dummy database. Updates the id and insert new
		 * customer in list.
		 * 
		 * @param customer
		 *            Customer object
		 * @return customer object with updated id
		 */
		public boolean insert(Customer customer) {
			customer.setId(new Random().nextInt(1000));
			customers.add(customer);
			String query = "insert into customer values('"+customer.getFirstName()+"','"+customer.getLastName()+"')";
			jdbcTemplate.update(query);
			return false;
		}

		/**
		 * Delete the customer object from dummy database. If customer not found for
		 * given id, returns null.
		 * 
		 * @param id
		 *            the customer id
		 * @return id of deleted customer object
		 */
		public boolean delete(Integer id) {

			for (Customer c : customers) {
				if (c.getId().equals(id)) {
					customers.remove(c);
					return true;
				}
			}

			return false;
		}

		/**
		 * Update the customer object for given id in dummy database. If customer
		 * not exists, returns null
		 * 
		 * @param id
		 * @param customer
		 * @return customer object with id
		 */
		public boolean update(Integer id, Customer customer) {

			for (Customer c : customers) {
				if (c.getId().equals(id)) {
					customer.setId(c.getId());
					customers.remove(c);
					customers.add(customer);
					return true;
				}
			}

			return false;
		}

		public Integer count() {
			String sql = "SELECT COUNT(*) FROM CUSTOMER";
			int total = jdbcTemplate.queryForInt(sql);
			return total;
		}

}
