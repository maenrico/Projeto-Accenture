package com.acc.consumo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.acc.consumo.model.Consumo;
import com.acc.consumo.model.Pedido;
import com.acc.consumo.model.PedidoGetway;
import com.acc.consumo.model.ProdutoGetway;
import com.acc.consumo.repository.PedidoGetwayRepository;
import com.acc.consumo.repository.ProdutoGetwayRepository;

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
    
    @Autowired
    private PedidoGetwayRepository pedidoRepository;
    
    @Autowired
    private ProdutoGetwayRepository produtoRepository;
    
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

        pedido.setNomeProduto(produto.getNomeProduto());
        pedido.setValorTotal(pedido.getValorTotal());
        pedido.setHora(pedido.getHora());
        pedido.setNome(usuario.getNome());
        pedido.setContato(usuario.getContato());
        pedido.setStatusPagamento(pagamento.getStatusPagamento());

        return pedido;
    }
    
    public Mono<Pedido> newPedido(Pedido pedido) {
        
    	Mono<Pedido> monoPedido = webClientPedidos
                .post()
                .uri("/pedido")
                .body(Mono.just(pedido), Pedido.class)
                .retrieve()
                .bodyToMono(Pedido.class);
		
    	return monoPedido;
    }
    
    public Pedido buscarPedido(Long id) {
        
    	Mono<Pedido> monoPedido = this.webClientPedidos
    			.method(HttpMethod.GET)
                .uri("/pedido/{id}", id )
                .retrieve()
                .bodyToMono(Pedido.class);
    	
    	Pedido pedido = monoPedido.block();
    	
    	return pedido;
    }
    
    public ProdutoGetway buscarProduto(Long id) {
        
    	Mono<ProdutoGetway> monoProduto = webClientProdutos
    			.method(HttpMethod.GET)
                .uri("/produto/{id}", id )
                .retrieve()
                .bodyToMono(ProdutoGetway.class);
    	
    	ProdutoGetway produto = monoProduto.block();
    	
    	return produto;
    }
    
    public List<ProdutoGetway> listarProdutos() {
    	
    	Flux<ProdutoGetway> fluxProduto = webClientProdutos
    			.method(HttpMethod.GET)
    			.uri("/produto")
    			.retrieve()
    			.bodyToFlux(ProdutoGetway.class);
    	
    	List<ProdutoGetway> produtos = fluxProduto.toStream().map(x -> x).collect(Collectors.toList());
    	
    	return produtos;
    }
    
    public PedidoGetway fazerPedido(Long idProduto, Long idPedido) {
    	
    	ProdutoGetway produto = buscarProduto(idProduto);
    	
    	Pedido pedido = buscarPedido(idPedido);
    	
    	List<ProdutoGetway> produtos = listarProdutos();
    	
    	PedidoGetway pedidoProduto = new PedidoGetway();
    	
    	pedidoProduto.setId(pedido.getId());
    	pedidoProduto.setHora(pedido.getHora());
    	pedidoProduto.setValorTotal(produto.getValor());
    	pedidoProduto.setStatus(pedido.getStatus());
    	
    	List<ProdutoGetway> listaProdutos = new ArrayList<>();
    	
    	for(int i = 0; i < produtos.size(); i++) {
    		if(idProduto == produtos.get(i).getId()) {
    			listaProdutos.add(produtos.get(i));
    			produtoRepository.save(produtos.get(i));
    		}
    	}
    	
    	pedidoProduto.setProdutos(listaProdutos);

    	return this.pedidoRepository.save(pedidoProduto);
    }
    
    public PedidoGetway adicionarProduto(Long idProduto, Long idPedido) {
    	
    	List<ProdutoGetway> produtos = listarProdutos();
    	PedidoGetway pedido = pedidoRepository.findById(idPedido).get();
    	
    	List<ProdutoGetway> listaProdutos = new ArrayList<>();
    	
    	for(int i = 0; i < pedido.getProdutos().size(); i++) {
    		listaProdutos.add(pedido.getProdutos().get(i));
    	}
    	
    	for(int i = 0; i < produtos.size(); i++) {
    		if(idProduto == produtos.get(i).getId()) {
    			listaProdutos.add(produtos.get(i));
    			produtoRepository.save(produtos.get(i));
    			pedido.setValorTotal(pedido.getValorTotal() + produtos.get(i).getValor()); 
    		}
    	}
    	
    	pedido.setProdutos(listaProdutos);
    	
    	return pedidoRepository.save(pedido);
    	
    }
}