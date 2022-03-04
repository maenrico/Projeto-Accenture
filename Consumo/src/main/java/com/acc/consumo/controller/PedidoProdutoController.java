package com.acc.consumo.controller;

import com.acc.consumo.model.PedidoComProduto;
import com.acc.consumo.service.PedidoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoProdutoController {

    @Autowired
    PedidoProdutoService pedidoProdutoService;


    @GetMapping("/produto/{id}/pedido")
    public ResponseEntity<PedidoComProduto> obterPedidoComProduto (@PathVariable Long id){

        PedidoComProduto pedidoComProduto = this.pedidoProdutoService.obterPedidoComProduto(id);

        return ResponseEntity.status(HttpStatus.OK).body(pedidoComProduto);
    }



}
