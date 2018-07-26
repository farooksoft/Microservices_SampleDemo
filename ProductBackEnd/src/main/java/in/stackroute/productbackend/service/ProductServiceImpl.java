package in.stackroute.productbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.stackroute.productbackend.model.Product;
import in.stackroute.productbackend.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public boolean save(Product product) {
		return (productRepository.save(product) != null);
	}

	@Override
	public boolean update(Product product) {
		return (productRepository.save(product) != null);
	}

	@Override
	public boolean delete(Product product) {
		productRepository.delete(product);
		if (productRepository.findOne(product.getId()) != null) {
			return false;
		} else
			return true;
	}

	@Override
	public List<Product> list() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product get(long id) {
		return productRepository.findOne(id);
	}

}
