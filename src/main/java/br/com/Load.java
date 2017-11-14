package br.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.constants.ImageType;
import br.com.estudo.dao.ContaRepository;
import br.com.estudo.dao.MovimentacaoRepository;
import br.com.estudo.exception.BusinessException;
import br.com.estudo.model.Conta;
import br.com.estudo.model.Image;
import br.com.estudo.model.Movimentacao;
import br.com.estudo.model.Product;
import br.com.estudo.service.ImageService;
import br.com.estudo.service.ProductService;

@Service
public class Load {

    @Autowired
    private ProductService productService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public void contextLoads() {

	Product product1 = getNewProduct("Ninetendo Switch");
	try {
	    productService.save(product1);
	    addImagesTOProduct(ImageType.JPG, product1);
	} catch (BusinessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}


	Product product2 = getNewProduct("Controle Ninetendo Switch");
	// product2.setParent(product1);
	try {
	    productService.save(product2);
	    addImagesTOProduct(ImageType.TIFF, product2);
	} catch (BusinessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}


	Product product3 = getNewProduct("Jogo Mario Ninetendo Switch");
	// product3.setParent(product1);
	try {
	    productService.save(product3);
	    addImagesTOProduct(ImageType.GIF, product3);
	} catch (BusinessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}


	List<Product> products1 = productService.findAllWithParentProductsAndImage();

	// List<Product> products2 =
	// productService.findAllWithParentProductsAndImage(product1);

	List<Image> images = imageService.findAllByProduct();

	// List<Product> products3 = productService.findAllWithParentProducts();

	System.out.println("FIM");

    }

    public void contextLoadsConta() {

	Conta conta = getNewConta("Bradesco");
	try {
	    contaRepository.save(conta);
	    addImagesMovimentacoesTOContas(conta);
	} catch (BusinessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	Conta conta2 = getNewConta("Itau");
	try {
	    contaRepository.save(conta2);
	    addImagesMovimentacoesTOContas(conta2);
	} catch (BusinessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	Conta conta3 = getNewConta("Caixa");
	try {
	    contaRepository.save(conta3);
	    addImagesMovimentacoesTOContas(conta3);
	} catch (BusinessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}


	List<Product> products1 = productService.findAllWithParentProductsAndImage();

	// List<Product> products2 =
	// productService.findAllWithParentProductsAndImage(product1);

	List<Image> images = imageService.findAllByProduct();

	// List<Product> products3 = productService.findAllWithParentProducts();

	System.out.println("FIM");

    }

    private Product getNewProduct(String name) {
	Product product = new Product();
	product.setName(name);

	return product;
    }

    private Conta getNewConta(String banco) {
	Conta conta = new Conta();
	conta.setBanco(banco);
	conta.setNumero(123);
	conta.setAgencia("3");

	return conta;
    }

    private void addImagesTOProduct(ImageType type, Product product) throws BusinessException {
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

    private void addImagesMovimentacoesTOContas(Conta conta) throws BusinessException {
	Movimentacao m1 = new Movimentacao();
	m1.setConta(conta);
	m1.setValor(200.00);
	Movimentacao m2 = new Movimentacao();
	m2.setConta(conta);
	m2.setValor(200.00);
	Movimentacao m3 = new Movimentacao();
	m3.setConta(conta);
	m3.setValor(200.00);

	movimentacaoRepository.save(m1);
	movimentacaoRepository.save(m2);
	movimentacaoRepository.save(m3);

    }

}
