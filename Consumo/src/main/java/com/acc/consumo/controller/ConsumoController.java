package com.acc.consumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acc.consumo.model.Consumo;
import com.acc.consumo.service.ConsumoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
public class ConsumoController {

    @Autowired
    ConsumoService consumoService;


    @GetMapping("/{id}")
    public ResponseEntity<Consumo> obterConsumo (@PathVariable Long id){

        Consumo consumo = this.consumoService
        		.obterConsumo(id);

        return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(consumo);
    }
    @GetMapping("/produto")
    public ResponseEntity<Flux<Consumo>> obterConsumoProduto (){

        Flux<Consumo> consumo = this.consumoService
        		.obterConsumoProduto();

        return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(consumo);
    }
    @GetMapping("/usuario")
    public ResponseEntity<Flux<Consumo>> obterConsumoUsuario (){

        Flux<Consumo> consumo = this.consumoService
        		.obterConsumoUsuario();

        return ResponseEntity.status(HttpStatus.OK).body(consumo);
    }
    @GetMapping("/pedido")
    public ResponseEntity<Flux<Consumo>> obterConsumoPedido (){

        Flux<Consumo> consumo = this.consumoService
        		.obterConsumoPedido();

        return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(consumo);
    }
    @GetMapping("/pagamento")
    public ResponseEntity<Flux<Consumo>> obterConsumoPagamento (){

        Flux<Consumo> consumo = this.consumoService
        		.obterConsumoPagamento();

        return ResponseEntity.status(HttpStatus.OK).body(consumo);
    }
    @PostMapping
    public ResponseEntity<Consumo> postConsumo(@RequestBody Consumo consumo){
		
        Consumo MANOBROWN = this.consumoService
        		.postConsumo(consumo);

    	
    	return ResponseEntity
    			.status(HttpStatus.OK)
    			.body(MANOBROWN);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteConsumo(Long idPedido){
    	
    	return this.consumoService.deleteConsumo(idPedido);
    }
}