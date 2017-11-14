package br.com.estudo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.estudo.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query("select distinct p from Product p left join fetch p.images")
	public List<Product> findAllWithParentProductsAndImage();

	/*
	 * @Query(
	 * "select distinct p from Product p left join fetch p.parent left join fetch p.images where p.id = :pProduct"
	 * ) public List<Product>
	 * findAllWithParentProductsAndImage(@Param("pProduct") Integer id);
	 * 
	 * @Query(
	 * "select distinct p from Product p left join fetch p.parent left join fetch p.images where p.id = :pProduct"
	 * ) public Product findWithParentProductsAndImage(@Param("pProduct")
	 * Integer id);
	 * 
	 * @Query(
	 * "select distinct p from Product p join p.parent join p.images where p.id = :pProduct"
	 * ) public List<Product> findAllByProduct(@Param("pProduct") Integer id);
	 * 
	 * @Query(
	 * "select distinct p from Product p join fetch p.parent where p.parent.id = :pProduct"
	 * ) public List<Product> findAllWithParentProducts(@Param("pProduct")
	 * Integer id);
	 */
}
