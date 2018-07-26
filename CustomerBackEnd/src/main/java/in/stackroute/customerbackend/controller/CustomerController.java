package in.stackroute.customerbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.stackroute.customerbackend.model.Customer;
import in.stackroute.customerbackend.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> listAllCustomers() {
		
		return new ResponseEntity<List<Customer>>(customerService.list(), HttpStatus.OK);

	}

	  
	/*
	 * Retrieve Single User
	 */ 
	 
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
		
		Customer customer = customerService.get(id);
		if (customer == null) {
			
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	 
	/*
	 * Create a new user
	 */ 
	 
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer u = customerService.get(customer.getId());
		if (u != null) {
			return new ResponseEntity<Customer>(HttpStatus.CONFLICT);
		}

		customerService.save(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}

	 
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id) {
		Customer customer = customerService.get(id);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}

		customerService.delete(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	/*
	 * Update an User 
	 */
	 
	@PutMapping(value = "/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		
		Customer currentCustomer = customerService.get(id);

		if (currentCustomer == null) {

			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}

		currentCustomer.setName(customer.getName());
		currentCustomer.setEmail(customer.getEmail());

		customerService.update(currentCustomer);
		return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
	}
}
