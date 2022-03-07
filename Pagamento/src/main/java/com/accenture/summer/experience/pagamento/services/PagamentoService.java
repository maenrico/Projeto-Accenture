package com.accenture.summer.experience.pagamento.services;

import com.accenture.summer.experience.pagamento.models.Pagamento;
import com.accenture.summer.experience.pagamento.repository.PagamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> findAll(){
        return this.pagamentoRepository.findAll();
    }
    public Optional<Pagamento> findById(Long id) {
        return this.pagamentoRepository.findById(id);
    }

    public Pagamento create(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }
    
    public void deleteById(Long id) {
    	
    	pagamentoRepository.deleteById(id);
    }
}
