package in.stackroute.customerbackend.service;

import java.util.List;

import in.stackroute.customerbackend.model.Customer;

public interface CustomerService {

	public boolean save(Customer customer);
	
	public boolean update(Customer customer);
	
	public boolean delete(Customer customer);
	
	public List<Customer> list();
		
	public Customer get(long id);
	
}
