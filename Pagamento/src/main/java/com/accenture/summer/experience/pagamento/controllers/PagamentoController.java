package com.accenture.summer.experience.pagamento.controllers;

import java.util.List;
import java.util.Optional;

import com.accenture.summer.experience.pagamento.models.StatusWrapper;
import com.accenture.summer.experience.pagamento.models.Pagamento;
import com.accenture.summer.experience.pagamento.services.PagamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/pagamento") 
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/all")
    @ResponseBody
    public List<Pagamento> getAll() {
        return pagamentoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Pagamento> getById(@PathVariable Long id) {
        return pagamentoService.findById(id);
    }

    @PostMapping("/create")
    @ResponseBody
    public Pagamento create(@RequestBody Pagamento pagamento) {
        return pagamentoService.create(pagamento);
    }
    
    @PutMapping("/update/{id}/status")
    @ResponseBody
    public Pagamento updateStatus(@PathVariable Long id, @RequestBody StatusWrapper status) {
        return pagamentoService.updateStatus(id, status);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Pagamento delete(@PathVariable Long id) {
        return pagamentoService.delete(id);
    }
    
}
