package com.acc.consumo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ch.qos.logback.core.status.Status;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Consumo {

    private Long id;
    private String nome;
    private String contato;
    private String nomeProduto;
    private String hora;
    private Double valorTotal;
    private String statusPagamento;
    private Status StatusCompleto;
    private Double valor;
    private String email;
    
    
    
	public Consumo() {
		super();
	}
	public Consumo(Long id, String nome, String contato, String nomeProduto, String hora, Double valorTotal,
			String statusPagamento, Status statusCompleto, Double valor, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.contato = contato;
		this.nomeProduto = nomeProduto;
		this.hora = hora;
		this.valorTotal = valorTotal;
		this.statusPagamento = statusPagamento;
		StatusCompleto = statusCompleto;
		this.valor = valor;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getStatusPagamento() {
		return statusPagamento;
	}
	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	public Status getStatusCompleto() {
		return StatusCompleto;
	}
	public void setStatusCompleto(Status statusCompleto) {
		StatusCompleto = statusCompleto;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}