package in.stackroute.customerbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.stackroute.customerbackend.model.Customer;
import in.stackroute.customerbackend.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public boolean save(Customer customer) {
		return (customerRepository.save(customer) != null);
	}

	@Override
	public boolean update(Customer customer) {
		return (customerRepository.save(customer) != null);
	}

	@Override
	public boolean delete(Customer customer) {
		customerRepository.delete(customer);
		if (customerRepository.findOne(customer.getId()) != null) {
			return false;
		} else
			return true;
	}

	@Override
	public List<Customer> list() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer get(long id) {
		return customerRepository.findOne(id);
	}

}
