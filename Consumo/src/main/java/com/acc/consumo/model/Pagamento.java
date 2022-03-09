package com.acc.consumo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pagamento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
    private Long id;
    private Double valorPago;
    private String statusPagamento;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	public String getStatusPagamento() {
		return statusPagamento;
	}
	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
}
