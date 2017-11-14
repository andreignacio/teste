package br.com.estudo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.estudo.constants.ImageType;
import br.com.estudo.model.Image;
import br.com.estudo.model.Product;
import br.com.estudo.service.ImageService;
import br.com.estudo.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsDataApiApplicationTests {

	@Autowired
	ImageService imageService;

	@Autowired
	ProductService productService;

	@Test
	public void contextLoads() {

		Product product1 = getNewProduct("Ninetendo Switch");
		productService.save(product1);
		addImagesTOProduct(ImageType.JPG, product1);

		Product product2 = getNewProduct("Controle Ninetendo Switch");
		// product2.setParent(product1);
		productService.save(product2);
		addImagesTOProduct(ImageType.TIFF, product2);


		Product product3 = getNewProduct("Jogo Mario Ninetendo Switch");
		// product3.setParent(product1);
		productService.save(product3);
		addImagesTOProduct(ImageType.GIF, product3);

		List<Product> products1 = productService.findAllWithParentProductsAndImage();

		// List<Product> products2 =
		// productService.findAllWithParentProductsAndImage(product1);

		// List<Product> products3 = productService.findAllWithParentProducts();

		System.out.println("FIM");

	}

	private Product getNewProduct(String name) {
		Product product = new Product();
		product.setName(name);

		return product;
	}

	private void addImagesTOProduct(ImageType type, Product product) {
		Image image1 = new Image();
		image1.setType(type);
		image1.setProduct(product);
		Image image2 = new Image();
		image2.setType(type);
		image2.setProduct(product);
		Image image3 = new Image();
		image3.setType(type);
		image3.setProduct(product);
		Image image4 = new Image();
		image4.setProduct(product);
		image4.setType(type);
		
		imageService.save(image1);
		imageService.save(image2);
		imageService.save(image3);
		imageService.save(image4);

	}

}
