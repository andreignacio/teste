package br.com.estudo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.estudo.model.Product;

@Repository
public class ProductDao {

    public ProductDao() {

    }

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> findAllWithParentProductsAndImage() {
	String hpql = "select distinct p from Product p left join fetch p.images";
	List<Product> resultList = entityManager.createQuery(hpql, Product.class).getResultList();
	return resultList;
    }

}
