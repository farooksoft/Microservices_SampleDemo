package in.stackroute.productbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.stackroute.productbackend.model.Product;
import in.stackroute.productbackend.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> listAllProducts() {
		
		return new ResponseEntity<List<Product>>(productService.list(), HttpStatus.OK);

	}
	 
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
		
		Product product = productService.get(id);
		if (product == null) {
			
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	 
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product u = productService.get(product.getId());
		if (u != null) {
			return new ResponseEntity<Product>(HttpStatus.CONFLICT);
		}

		productService.save(product);
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}

	 
	@PutMapping(value = "/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
		
		Product currentProduct = productService.get(id);

		if (currentProduct == null) {

			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		currentProduct.setDescription(product.getDescription());
		currentProduct.setSku(product.getSku());

		productService.update(currentProduct);
		return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
	}
}
