package com.acc.consumo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Consumo {

    private Long id;
    private String nome;
    private String contato;
    private String nomeProduto;
    private String hora;
    private Double valorTotal;
    private String statusPagamento;



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
    public String getNomeProduto() {
        return nomeProduto;
    }
    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }
    public String getHora() {
        return hora;
    }
    public String getStatusPagamento() {
        return statusPagamento;
    }
    public void setStatusPagamento(String status) {
        this.statusPagamento = status;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }



}