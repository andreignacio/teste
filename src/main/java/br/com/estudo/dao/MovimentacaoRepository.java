package br.com.estudo.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.estudo.model.Movimentacao;

public interface MovimentacaoRepository extends CrudRepository<Movimentacao, Long> {

}
