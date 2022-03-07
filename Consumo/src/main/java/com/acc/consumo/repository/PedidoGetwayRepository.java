package com.acc.consumo.repository;

import com.acc.consumo.model.PedidoGetway;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoGetwayRepository extends JpaRepository<PedidoGetway, Long>{

}
