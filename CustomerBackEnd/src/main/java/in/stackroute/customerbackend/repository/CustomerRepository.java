package in.stackroute.customerbackend.repository;

import org.springframework.data.repository.CrudRepository;

import in.stackroute.customerbackend.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
