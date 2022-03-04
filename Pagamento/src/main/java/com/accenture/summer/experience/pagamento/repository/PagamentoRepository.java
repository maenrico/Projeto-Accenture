package com.accenture.summer.experience.pagamento.repository;

import com.accenture.summer.experience.pagamento.models.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    
}
