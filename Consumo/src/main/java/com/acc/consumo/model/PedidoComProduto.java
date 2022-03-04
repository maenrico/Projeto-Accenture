package com.acc.consumo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class PedidoComProduto {

    private Long id;
    private String nome; //nome produto
    private String hora;
    private Double valorTotal;

    public PedidoComProduto(){}

    public PedidoComProduto(Long id, String nomeDoProduto, String hora, Double valorTotal) {
        this.id = id;
        this.nome = nomeDoProduto;
        this.hora = hora;
        this.valorTotal = valorTotal;
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
}
