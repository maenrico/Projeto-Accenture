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
 public String nome;
 public int valor;
 
public Produto(Long id, String nome, int valor) {
	super();
	this.id = id;
	this.nome = nome;
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

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public int getValor() {
	return valor;
}

public void setValor(int valor) {
	this.valor = valor;
 }
}
