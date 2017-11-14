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
import br.com.estudo.dao.ContaRepository;
import br.com.estudo.error.ApiError;
import br.com.estudo.model.Conta;
import br.com.estudo.service.ImageService;

@RestController
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    private Load load;


    @RequestMapping(value = "/conta", method = RequestMethod.GET)
    public ResponseEntity<List<Conta>> save() {

	load.contextLoadsConta();

	List<Conta> products = contaRepository.findAllContasWithMovimentacoes();
	ResponseEntity<List<Conta>> responseEntity = new ResponseEntity<List<Conta>>(products, HttpStatus.OK);

	return responseEntity;
    }






    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
	ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred");
	return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

}
