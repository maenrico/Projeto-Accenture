package com.acc.consumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acc.consumo.model.Consumo;
import com.acc.consumo.model.Pagamento;
import com.acc.consumo.model.Pedido;
import com.acc.consumo.model.PedidoGetway;
import com.acc.consumo.model.Usuario;
import com.acc.consumo.service.ConsumoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ConsumoController {

	@Autowired
	ConsumoService consumoService;
	
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

	@GetMapping("/produto/{idProduto}/pedido/{idPedido}")
	public ResponseEntity<PedidoGetway> novoPedido(@PathVariable Long idProduto, @PathVariable Long idPedido) {

		PedidoGetway pedidoProduto = consumoService.fazerPedido(idProduto, idPedido);

		return ResponseEntity.status(HttpStatus.OK).body(pedidoProduto);
	}

	@PostMapping("/pedido")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Pedido> create(@RequestBody Pedido pedido) {
		return consumoService.newPedido(pedido);
	}
	
	@PutMapping("/produto/{idProduto}/pedido/{idPedido}")
	public PedidoGetway updateProdutoById(@PathVariable Long idProduto, @PathVariable Long idPedido) {
		PedidoGetway updatePedido = consumoService.adicionarProduto(idProduto, idPedido);
		return updatePedido;
	}
	
	@PostMapping("/pedido/{idPedido}/usuario/{idUsuario}")
	public Usuario atribuiUsuario(@PathVariable Long idPedido, @PathVariable Long idUsuario) {
		Usuario usuarioPedido = consumoService.atribuiUsuario(idPedido, idUsuario);
		return usuarioPedido;
		
	}
	
	@PutMapping("/pedido/{idPedido}/usuario/{idUsuario}")
	public Usuario updatePedidoUsuario(@PathVariable Long idPedido, @PathVariable Long idUsuario) {
		Usuario usuario = consumoService.updatePedidoUsuario(idPedido, idUsuario);
		return usuario;
	}
	
	@GetMapping("/usuario/{id}/pedido")
	public Usuario getUsuarioPeidodById(@PathVariable Long id) {
		Usuario usuario = consumoService.getUsuarioById(id);
		return usuario;
	}
	
	@PutMapping("pedido/{idPedido}/pagamento")
	public Pagamento pagarPedido(@PathVariable Long idPedido, @RequestBody Pagamento pagamento) {
		return consumoService.realizarPagamento(idPedido, pagamento);
	}

}