package br.com.estudo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import br.com.estudo.dao.ProductRepository;
import br.com.estudo.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

	public void save(Product product) {
		repository.save(product);
	}

	public void save(List<Product> product) {
		repository.save(product);
	}

	public void updade(Product product) {
		repository.save(product);
	}

	public void delete(Product product) {

		repository.delete(product);
	}

	public List<Product> findAll() {
		Iterable<Product> products = repository.findAll();
		return Lists.newArrayList(products);
	}

	public List<Product> findAllWithParentProductsAndImage() {
		List<Product> products = repository.findAllWithParentProductsAndImage();
		return products;
	}

	/*public List<Product> findAllWithParentProductsAndImage(Integer id) {
		List<Product> products = repository.findAllWithParentProductsAndImage(id);
		return products;
	}

	public Product findWithParentProductsAndImage(Integer id) {
		Product products = repository.findWithParentProductsAndImage(id);
		return products;
	}

	public List<Product> findAllByProduct(Integer id) {
		List<Product> products = repository.findAllByProduct(id);
		return products;
	}

	public List<Product> findAllWithParentProducts(Integer id) {
		List<Product> products = repository.findAllWithParentProducts(id);
		return products;
	}*/


}
