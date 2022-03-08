package com.acc.consumo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {

	@Id
	@Column(name = "usuario_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String contato;
	
	@ManyToMany
    @JoinTable(name = "pedidos_usuario",
    joinColumns = @JoinColumn(name = "pedidogetway_id"),
    inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	private List<PedidoGetway> pedidos = new ArrayList<>();

	public Usuario() {}
	
	public Usuario(Long id, String nome, String email, String contato) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.contato = contato;
	}

	public Usuario(Usuario entity) {
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
		contato = entity.getContato();
		pedidos = entity.getPedidos().stream().map(x -> x).collect(Collectors.toList());
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

	public List<PedidoGetway> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoGetway> pedidos) {
		this.pedidos = pedidos;
	}

}
