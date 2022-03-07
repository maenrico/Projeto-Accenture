package com.accenture.summer.experience.pagamento.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.summer.experience.pagamento.models.Pagamento;
import com.accenture.summer.experience.pagamento.services.PagamentoService;


@RestController
@RequestMapping(value = "/pagamento") 
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping()
    @ResponseBody
    public List<Pagamento> getAll() {
        return pagamentoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Pagamento> getById(@PathVariable Long id) {
        return pagamentoService.findById(id);
    }

    @PostMapping()
    @ResponseBody
    public Pagamento create(@RequestBody Pagamento pagamento) {
        return pagamentoService.create(pagamento);
    }
    
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
    	pagamentoService.deleteById(id);
    }
    
}
