package br.com.estudo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.estudo.model.Image;


public interface ImageRepository extends CrudRepository<Image, Long> {

    @Query("select i from Image i join fetch i.product")
    public List<Image> findAllByProduct();

}
