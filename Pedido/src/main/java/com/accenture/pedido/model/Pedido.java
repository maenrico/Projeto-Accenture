package com.accenture.pedido.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Pedido implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hora;

    private Double valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public Pedido() {
    }

    public Pedido(Long id, String hora, Double valorTotal, StatusPedido status) {
        this.id = id;
        this.hora = hora;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = StatusPedido.valueOf(status);
    }
}