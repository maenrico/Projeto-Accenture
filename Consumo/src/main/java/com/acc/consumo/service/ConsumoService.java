package com.acc.consumo.service;

import com.acc.consumo.model.Consumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ConsumoService {

    @Autowired
    private WebClient webClientProdutos;

    @Autowired
    private WebClient webClientPedidos;

    @Autowired
    private WebClient webClientUsuarios;

    @Autowired
    private WebClient webClientPagamentos;

    /* Códigos abaixo referente ao getById no modelo:
     * 	NOME_PRODUTO
     * 	VALOR_TOTAL
     * 	HORA
     * 	NOME
     * 	CONTATO
     * 	PAGAMENTO 
     *												*/
    
    public Consumo obterConsumo(Long idPedido){

        Mono<Consumo> monoProduto = this.webClientProdutos.method(HttpMethod.GET)
                .uri("/produto/{id}", idPedido )
                .retrieve()
                .bodyToMono(Consumo.class);


        Mono<Consumo> monoPedido = this.webClientPedidos
                .method(HttpMethod.GET)
                .uri("/pedido/{id}", idPedido)
                .retrieve()
                .bodyToMono(Consumo.class);


        Mono<Consumo> monoUsuario = this.webClientUsuarios
                .method(HttpMethod.GET)
                .uri("/usuario/{id}", idPedido)
                .retrieve()
                .bodyToMono(Consumo.class);

        Mono<Consumo> monoPagamento = this.webClientPagamentos
                .method(HttpMethod.GET)
                .uri("/pagamento/{id}", idPedido)
                .retrieve()
                .bodyToMono(Consumo.class);

        Consumo pedido = monoPedido.block();
        Consumo pagamento = monoPagamento.block();
        Consumo produto =  monoProduto.block();
        Consumo usuario = monoUsuario.block();

		//ABAIXO O MODELO QUE SERÁ CHAMADO NESTE MÉTODO// 
        
        pedido.setNomeProduto(produto.getNomeProduto());
        pedido.setValorTotal(pedido.getValorTotal());
        pedido.setHora(pedido.getHora());
        pedido.setNome(usuario.getNome());
        pedido.setContato(usuario.getContato());
        pedido.setStatusPagamento(pagamento.getStatusPagamento());

        return pedido;
    }
    
    /* Códigos abaixo referente ao post no model Consumo*/
     
    public Consumo postConsumo(Consumo consumo){
    	
    	Mono<Consumo> monoProduto = this.webClientProdutos
    			.post()
                .uri("/produto" )
                .body(Mono.just(consumo), Consumo.class)
                .retrieve()
                .bodyToMono(Consumo.class);

        Mono<Consumo> monoPedido = this.webClientPedidos
                .post()
                .uri("/pedido")
                .body(Mono.just(consumo), Consumo.class)
                .retrieve()
                .bodyToMono(Consumo.class);

        Mono<Consumo> monoUsuario = this.webClientUsuarios
                .post()
                .uri("/usuario")
                .body(Mono.just(consumo), Consumo.class)
                .retrieve()
                .bodyToMono(Consumo.class);

        Mono<Consumo> monoPagamento = this.webClientPagamentos
                .post()
                .uri("/pagamento")
                .body(Mono.just(consumo), Consumo.class)
                .retrieve()
                .bodyToMono(Consumo.class);

		monoPedido.block();
		monoPagamento.block();
		monoProduto.block();
		monoUsuario.block();
		return consumo;
    }
    
    /* Códigos abaixo referente ao getAll() de cada rota*/
    
    public Flux<Consumo> obterConsumoProduto(){

        return this.webClientProdutos.get()
                .uri("/produto")
                .retrieve()
                .bodyToFlux(Consumo.class);
    }
    
        public Flux<Consumo> obterConsumoPedido(){

        return this.webClientPedidos.get()
                .uri("/pedido")
                .retrieve()
                .bodyToFlux(Consumo.class);
        }
        
        public Flux<Consumo> obterConsumoUsuario(){
        	
        return webClientUsuarios
                .get()
                .uri("/usuario")
                .retrieve()
                .bodyToFlux(Consumo.class);
        }
        
        public Flux<Consumo> obterConsumoPagamento(){
        
        return this.webClientPagamentos
                .get()
                .uri("/pagamento")
                .retrieve()
                .bodyToFlux(Consumo.class);
    }
        
        /*CÓDIGOS ABAIXO REFERENTE AO DELETEById de todas as rotas*/
        
        public Mono<Void> deleteConsumo(Long idPedido){

             this.webClientProdutos
            		.delete()
                    .uri("/produto/{id}", idPedido )
                    .retrieve()
                    .bodyToMono(Void.class);
             
        	 this.webClientPedidos
                    .delete()
                    .uri("/pedido/{id}", idPedido)
                    .retrieve()
                    .bodyToMono(Void.class);

              this.webClientUsuarios
                    .delete()
                    .uri("/usuario/{id}", idPedido)
                    .retrieve()
                    .bodyToMono(Void.class);
        
              this.webClientPagamentos
                    .delete()
                    .uri("/pagamento/{id}", idPedido)
                    .retrieve()
                    .bodyToMono(Void.class);
              
              return null;
        }
}