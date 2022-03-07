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

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
public class PedidoGetway {

	@Id
	@Column(name = "pedidogetway_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String hora;
	private Double valorTotal;
	private String status;
	
	@ManyToMany
    @JoinTable(name = "pedidoProduto",
    joinColumns = @JoinColumn(name = "pedido_id"),
    inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<ProdutoGetway> produtos = new ArrayList<>();

	public PedidoGetway() {
	}
	
	public PedidoGetway(Long id, String hora, Double valorTotal, String status) {
		this.id = id;
		this.hora = hora;
		this.valorTotal = valorTotal;
		this.status = status;
	}

	public PedidoGetway(PedidoGetway entity) {
		id = entity.getId();
		hora = entity.getHora();
		valorTotal = entity.getValorTotal();
		status = entity.getStatus();
		produtos = entity.getProdutos().stream().map(x -> x).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ProdutoGetway> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoGetway> produtos) {
		this.produtos = produtos;
	}
	
	
}
