package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 public Long id;
 public String nomeProduto;
 public int valor;
 
public Produto(Long id, String nome, int valor) {
	super();
	this.id = id;
	this.nomeProduto = nome;
	this.valor = valor;
}

public Produto() {
	super();
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNomeProduto() {
	return nomeProduto;
}

public void setNomeProduto(String nome) {
	this.nomeProduto = nome;
}

public int getValor() {
	return valor;
}

public void setValor(int valor) {
	this.valor = valor;
 }
}
