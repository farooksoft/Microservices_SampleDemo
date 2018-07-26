package in.stackroute.productbackend.service;

import java.util.List;

import in.stackroute.productbackend.model.Product;

public interface ProductService {

	public boolean save(Product product);
	
	public boolean update(Product product);
	
	public boolean delete(Product product);
	
	public List<Product> list();
		
	public Product get(long id);
}
