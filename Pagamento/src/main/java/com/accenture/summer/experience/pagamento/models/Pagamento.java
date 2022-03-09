package com.accenture.summer.experience.pagamento.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorPago;
    @Enumerated(EnumType.STRING)
    private Status statusPagamento;

    public Pagamento() {}

    public Pagamento(Long id, Status status) {
        this.id = id;
        this.statusPagamento = status;
    }
    
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

	public void setStatusPagamento(Status statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public Status getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String status) {
        this.statusPagamento = Status.valueOf(status);
    }
}
