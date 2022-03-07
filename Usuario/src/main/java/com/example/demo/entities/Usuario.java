package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nome;
 private String email;
 private String contato;
 //private Endereco endereco;
 
 public Usuario(Long id, String nome, String email, String contato) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.contato = contato;
	}
 
 public Usuario() {
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContato() {
	return contato;
}
public void setContato(String contato) {
	this.contato = contato;
}
 
 
}
