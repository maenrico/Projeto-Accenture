package com.accenture.summer.experience.pagamento.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status statusPagamento;

    public Pagamento() {}

    public Pagamento(Long id, Status status) {
        this.id = id;
        this.statusPagamento = status;
    }

    public Status getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String status) {
        this.statusPagamento = Status.valueOf(status);
    }
}
