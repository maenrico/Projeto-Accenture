package com.acc.consumo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acc.consumo.model.ProdutoGetway;

@Repository
public interface ProdutoGetwayRepository extends JpaRepository<ProdutoGetway, Long>{

}
