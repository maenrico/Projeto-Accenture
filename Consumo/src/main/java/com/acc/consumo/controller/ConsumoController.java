package com.acc.consumo.controller;

import com.acc.consumo.model.Consumo;
import com.acc.consumo.service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ConsumoController {

    @Autowired
    ConsumoService consumoService;


    @GetMapping("/{id}")
    public ResponseEntity<Consumo> obterConsumo (@PathVariable Long id){

        Consumo consumo = this.consumoService.obterConsumo(id);

        return ResponseEntity.status(HttpStatus.OK).body(consumo);
    }



}