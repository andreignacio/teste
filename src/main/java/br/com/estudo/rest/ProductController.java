package br.com.estudo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import br.com.Load;
import br.com.estudo.dao.ProductDao;
import br.com.estudo.error.ApiError;
import br.com.estudo.model.Image;
import br.com.estudo.model.Product;
import br.com.estudo.service.ImageService;
import br.com.estudo.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ImageService imageBO;

    @Autowired
    ImageService imageService;

    @Autowired
    private Load load;

    @RequestMapping(value = "/structure", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAll() {

	load.contextLoads();

	List<Product> products = productDao.findAllWithParentProductsAndImage();
	ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	return responseEntity;
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> save() {

	load.contextLoads();

	List<Product> products = productDao.findAllWithParentProductsAndImage();
	ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	return responseEntity;
    }

    @RequestMapping(value = "/save/images", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> saveImage() {



	List<Image> listImages = imageBO.findAllByProduct();

	List<Product> products = productService.findAllWithParentProductsAndImage();
	ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	return responseEntity;
    }






    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
	ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred");
	return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

}
