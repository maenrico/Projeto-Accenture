package com.acc.consumo.service;

import com.acc.consumo.model.Consumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
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
}