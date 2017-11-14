package br.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ProductsDataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsDataApiApplication.class, args);
	}



}
