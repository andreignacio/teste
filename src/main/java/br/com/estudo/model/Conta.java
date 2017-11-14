package br.com.estudo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Conta() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String agencia;

    @Column(nullable = false)
    private String banco;

    @Column(nullable = false)
    private Integer numero;

    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> movimentacoes;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getAgencia() {
	return agencia;
    }

    public void setAgencia(String agencia) {
	this.agencia = agencia;
    }

    public String getBanco() {
	return banco;
    }

    public void setBanco(String banco) {
	this.banco = banco;
    }

    public Integer getNumero() {
	return numero;
    }

    public void setNumero(Integer numero) {
	this.numero = numero;
    }

    public List<Movimentacao> getMovimentacoes() {
	return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
	this.movimentacoes = movimentacoes;
    }

}
