package in.stackroute.productbackend.repository;

import org.springframework.data.repository.CrudRepository;

import in.stackroute.productbackend.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
