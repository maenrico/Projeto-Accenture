package com.accenture.summer.experience.pagamento.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* id
* order_id
* status
*/

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {
    
    public static final Integer STATUS_PENDING = 1;
    public static final Integer STATUS_RECEIVED = 2;
    public static final Integer STATUS_CANCELED = 3;
    
    public Pagamento() {

    }

    public Pagamento(Long pedidoId, Integer status) {
        this.pedidoId = pedidoId;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long pedidoId;

    @Column
    private Integer status;

    public Long getId() {
        return this.id;
    }

    public Long getPedidoId() {
        return this.pedidoId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public Integer getStatus() {
        return this.status;
    }

    // @Override
    // public String toString() {
    //     return "";
    // }

    // @Override
    // public boolean equals() {
    //     return false;
    // }

    // @Override
    // public int hashCode() {
    //     return 0;
    // }
}
