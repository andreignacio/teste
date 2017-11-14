package br.com.estudo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.estudo.model.Conta;

public interface ContaRepository extends CrudRepository<Conta, Long> {

    @Query("select distinct c from Conta c left join fetch c.movimentacoes")
    public List<Conta> findAllContasWithMovimentacoes();

}
